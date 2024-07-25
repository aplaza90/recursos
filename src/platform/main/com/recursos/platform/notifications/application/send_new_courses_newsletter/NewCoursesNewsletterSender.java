package com.recursos.platform.notifications.application.send_new_courses_newsletter;

import com.recursos.platform.courses.application.CoursesResponse;
import com.recursos.platform.courses.application.search_last.SearchLastCoursesQuery;
import com.recursos.platform.notifications.domain.EmailSender;
import com.recursos.platform.notifications.domain.NewCoursesNewsletter;
import com.recursos.platform.students.application.StudentResponse;
import com.recursos.platform.students.application.StudentsResponse;
import com.recursos.platform.students.application.search_all.SearchAllStudentsQuery;
import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.UuidGenerator;
import com.recursos.shared.domain.bus.event.EventBus;
import com.recursos.shared.domain.bus.query.QueryBus;

@Service
public final class NewCoursesNewsletterSender {
    private final static Integer       TOTAL_COURSES = 3;
    private final        QueryBus      queryBus;
    private final        EmailSender   sender;
    private final        UuidGenerator uuidGenerator;
    private final        EventBus      eventBus;

    public NewCoursesNewsletterSender(
        QueryBus queryBus,
        UuidGenerator uuidGenerator,
        EmailSender sender,
        EventBus eventBus
    ) {
        this.queryBus      = queryBus;
        this.uuidGenerator = uuidGenerator;
        this.sender        = sender;
        this.eventBus      = eventBus;
    }

    public void send() {
        CoursesResponse courses = queryBus.ask(new SearchLastCoursesQuery(TOTAL_COURSES));

        if (courses.courses().size() > 0) {
            StudentsResponse students = queryBus.ask(new SearchAllStudentsQuery());

            students.students().forEach(student -> send(student, courses));
        }
    }

    public void send(StudentResponse student, CoursesResponse courses) {
        NewCoursesNewsletter newsletter = NewCoursesNewsletter.send(uuidGenerator.generate(), student, courses);

        sender.send(newsletter);

        eventBus.publish(newsletter.pullDomainEvents());
    }
}
