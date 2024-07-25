package com.recursos.platform.notifications.application.send_new_courses_newsletter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.recursos.platform.courses.application.CoursesResponse;
import com.recursos.platform.courses.application.CoursesResponseMother;
import com.recursos.platform.courses.application.search_last.SearchLastCoursesQuery;
import com.recursos.platform.courses.application.search_last.SearchLastCoursesQueryMother;
import com.recursos.platform.notifications.application.NotificationsModuleUnitTestCase;
import com.recursos.platform.notifications.domain.NewCoursesNewsletter;
import com.recursos.platform.notifications.domain.NewCoursesNewsletterEmailSent;
import com.recursos.platform.notifications.domain.NewCoursesNewsletterEmailSentMother;
import com.recursos.platform.notifications.domain.NewCoursesNewsletterMother;
import com.recursos.platform.students.application.StudentResponse;
import com.recursos.platform.students.application.StudentResponseMother;
import com.recursos.platform.students.application.StudentsResponse;
import com.recursos.platform.students.application.StudentsResponseMother;
import com.recursos.platform.students.application.search_all.SearchAllStudentsQuery;
import com.recursos.platform.students.application.search_all.SearchAllStudentsQueryMother;
import com.recursos.shared.domain.bus.command.CommandHandlerExecutionError;
import com.recursos.shared.domain.bus.query.QueryHandlerExecutionError;

import java.util.Arrays;

final class SendNewCoursesNewsletterCommandHandlerShould extends NotificationsModuleUnitTestCase {
    SendNewCoursesNewsletterCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new SendNewCoursesNewsletterCommandHandler(
            new NewCoursesNewsletterSender(queryBus, uuidGenerator, sender, eventBus)
        );
    }

    @Test
    void not_send_the_newsletter_when_there_are_no_courses() throws QueryHandlerExecutionError, CommandHandlerExecutionError {
        SendNewCoursesNewsletterCommand command = SendNewCoursesNewsletterCommandMother.random();

        SearchLastCoursesQuery coursesQuery    = SearchLastCoursesQueryMother.create(3);
        CoursesResponse        coursesResponse = CoursesResponseMother.empty();

        shouldAsk(coursesQuery, coursesResponse);

        handler.handle(command);
    }

    @Test
    void not_send_the_newsletter_when_there_are_no_students() throws QueryHandlerExecutionError, CommandHandlerExecutionError {
        SendNewCoursesNewsletterCommand command = SendNewCoursesNewsletterCommandMother.random();

        SearchLastCoursesQuery coursesQuery    = SearchLastCoursesQueryMother.create(3);
        CoursesResponse        coursesResponse = CoursesResponseMother.random();

        SearchAllStudentsQuery studentsQuery    = SearchAllStudentsQueryMother.random();
        StudentsResponse       studentsResponse = StudentsResponseMother.empty();

        shouldAsk(coursesQuery, coursesResponse);
        shouldAsk(studentsQuery, studentsResponse);

        handler.handle(command);
    }

    @Test
    void send_the_new_courses_newsletter() throws QueryHandlerExecutionError, CommandHandlerExecutionError {
        SendNewCoursesNewsletterCommand command = SendNewCoursesNewsletterCommandMother.random();

        SearchLastCoursesQuery coursesQuery    = SearchLastCoursesQueryMother.create(3);
        CoursesResponse        coursesResponse = CoursesResponseMother.times(3);

        SearchAllStudentsQuery studentsQuery    = SearchAllStudentsQueryMother.random();
        StudentResponse        student          = StudentResponseMother.random();
        StudentResponse        otherStudent     = StudentResponseMother.random();
        StudentsResponse       studentsResponse = StudentsResponseMother.create(Arrays.asList(student, otherStudent));

        NewCoursesNewsletter newsletter      = NewCoursesNewsletterMother.create(student, coursesResponse);
        NewCoursesNewsletter otherNewsletter = NewCoursesNewsletterMother.create(otherStudent, coursesResponse);

        NewCoursesNewsletterEmailSent domainEvent = NewCoursesNewsletterEmailSentMother.create(
            newsletter.id(),
            student.id()
        );
        NewCoursesNewsletterEmailSent otherDomainEvent = NewCoursesNewsletterEmailSentMother.create(
            otherNewsletter.id(),
            otherStudent.id()
        );

        shouldAsk(coursesQuery, coursesResponse);
        shouldAsk(studentsQuery, studentsResponse);

        shouldGenerateUuids(newsletter.id().value(), otherNewsletter.id().value());

        handler.handle(command);

        shouldHaveSentEmail(newsletter);
        shouldHavePublished(domainEvent);

        shouldHaveSentEmail(otherNewsletter);
        shouldHavePublished(otherDomainEvent);
    }
}
