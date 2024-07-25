package com.recursos.platform.courses_counter.application.find;

import com.recursos.shared.domain.IntegerMother;

final class CoursesCounterResponseMother {
    public static CoursesCounterResponse create(Integer value) {
        return new CoursesCounterResponse(value);
    }

    public static CoursesCounterResponse random() {
        return create(IntegerMother.random());
    }
}
