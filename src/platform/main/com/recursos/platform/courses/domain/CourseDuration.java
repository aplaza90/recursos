package com.recursos.platform.courses.domain;

import com.recursos.shared.domain.StringValueObject;

public final class CourseDuration extends StringValueObject {
    public CourseDuration(String value) {
        super(value);
    }

    private CourseDuration() {
        super("");
    }
}
