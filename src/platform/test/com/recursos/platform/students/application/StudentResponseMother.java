package com.recursos.platform.students.application;

import com.recursos.platform.students.domain.StudentId;
import com.recursos.platform.students.domain.StudentIdMother;
import com.recursos.shared.domain.EmailMother;
import com.recursos.shared.domain.WordMother;

public final class StudentResponseMother {
    public static StudentResponse create(StudentId id, String name, String surname, String email) {
        return new StudentResponse(id.value(), name, surname, email);
    }

    public static StudentResponse random() {
        return create(StudentIdMother.random(), WordMother.random(), WordMother.random(), EmailMother.random());
    }
}
