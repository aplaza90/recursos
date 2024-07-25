package com.recursos.platform.courses.application;

import com.recursos.platform.courses.domain.*;

public final class CourseResponseMother {
    public static CourseResponse create(CourseId id, CourseName name, CourseDuration duration) {
        return new CourseResponse(id.value(), name.value(), duration.value());
    }

    public static CourseResponse random() {
        return create(CourseIdMother.random(), CourseNameMother.random(), CourseDurationMother.random());
    }
}
