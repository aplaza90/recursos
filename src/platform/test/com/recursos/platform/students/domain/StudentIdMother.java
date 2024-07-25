package com.recursos.platform.students.domain;

import com.recursos.shared.domain.UuidMother;

public final class StudentIdMother {
    public static StudentId create(String value) {
        return new StudentId(value);
    }

    public static StudentId random() {
        return create(UuidMother.random());
    }
}
