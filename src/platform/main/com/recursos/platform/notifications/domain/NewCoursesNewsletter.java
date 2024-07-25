package com.recursos.platform.notifications.domain;

import com.recursos.platform.courses.application.CoursesResponse;
import com.recursos.platform.students.application.StudentResponse;

import java.util.Objects;

public final class NewCoursesNewsletter extends Email {
    private final StudentResponse student;
    private final CoursesResponse courses;

    public NewCoursesNewsletter(EmailId id, StudentResponse student, CoursesResponse courses) {
        super(id, "news@recursos.com", student.email(), "Últimos recursos publicados", formatBody(student, courses));

        this.student = student;
        this.courses = courses;
    }

    private static String formatBody(StudentResponse student, CoursesResponse courses) {
        return String.format(
            "Hola %s, se han publicado %s nuevos recursos",
            student.name(),
            courses.courses().size()
        );
    }

    public static NewCoursesNewsletter send(String id, StudentResponse student, CoursesResponse courses) {
        NewCoursesNewsletter newsletter = new NewCoursesNewsletter(new EmailId(id), student, courses);

        newsletter.record(new NewCoursesNewsletterEmailSent(id, student.id()));

        return newsletter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        NewCoursesNewsletter that = (NewCoursesNewsletter) o;
        return student.equals(that.student) &&
               courses.equals(that.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), student, courses);
    }
}
