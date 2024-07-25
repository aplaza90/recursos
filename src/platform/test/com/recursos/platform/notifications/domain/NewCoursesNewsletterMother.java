package com.recursos.platform.notifications.domain;

import com.recursos.platform.courses.application.CoursesResponse;
import com.recursos.platform.courses.application.CoursesResponseMother;
import com.recursos.platform.students.application.StudentResponse;
import com.recursos.platform.students.application.StudentResponseMother;

public final class NewCoursesNewsletterMother {
    public static NewCoursesNewsletter create(EmailId id, StudentResponse student, CoursesResponse courses) {
        return new NewCoursesNewsletter(id, student, courses);
    }

    public static NewCoursesNewsletter create(StudentResponse student, CoursesResponse courses) {
        return new NewCoursesNewsletter(EmailIdMother.random(), student, courses);
    }

    public static NewCoursesNewsletter random() {
        return create(EmailIdMother.random(), StudentResponseMother.random(), CoursesResponseMother.random());
    }
}
