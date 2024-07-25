package com.recursos.platform.students.application.search_all;

import com.recursos.platform.students.application.StudentResponse;
import com.recursos.platform.students.application.StudentsResponse;
import com.recursos.platform.students.domain.StudentRepository;
import com.recursos.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class AllStudentsSearcher {
    private final StudentRepository repository;

    public AllStudentsSearcher(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentsResponse search() {
        return new StudentsResponse(
            repository.searchAll().stream().map(StudentResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
