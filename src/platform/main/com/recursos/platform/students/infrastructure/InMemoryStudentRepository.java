package com.recursos.platform.students.infrastructure;

import com.recursos.platform.students.domain.Student;
import com.recursos.platform.students.domain.StudentId;
import com.recursos.platform.students.domain.StudentRepository;
import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.UuidGenerator;

import java.util.Arrays;
import java.util.List;

@Service
public final class InMemoryStudentRepository implements StudentRepository {
    private UuidGenerator generator;

    public InMemoryStudentRepository(UuidGenerator generator) {
        this.generator = generator;
    }

    @Override
    public List<Student> searchAll() {
        return Arrays.asList(
            new Student(new StudentId(generator.generate()), "name", "surname", "email@mail.com"),
            new Student(new StudentId(generator.generate()), "Other name", "Other surname", "another@mail.com")
        );
    }
}
