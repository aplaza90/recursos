package com.recursos.platform.courses.application.create;

import com.recursos.platform.courses.domain.*;

public final class CreateCourseCommandMother {
    public static CreateCourseCommand create(CourseId id, CourseName name, CourseDuration duration) {
        return new CreateCourseCommand(id.value(), name.value(), duration.value());
    }

    public static CreateCourseCommand random() {
        return create(CourseIdMother.random(), CourseNameMother.random(), CourseDurationMother.random());
    }
}
