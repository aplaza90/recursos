package com.recursos.platform.courses_counter.application.find;

import com.recursos.platform.courses_counter.domain.CoursesCounter;
import com.recursos.platform.courses_counter.domain.CoursesCounterNotInitialized;
import com.recursos.platform.courses_counter.domain.CoursesCounterRepository;
import com.recursos.shared.domain.Service;

@Service
public final class CoursesCounterFinder {
    private CoursesCounterRepository repository;

    public CoursesCounterFinder(CoursesCounterRepository repository) {
        this.repository = repository;
    }

    public CoursesCounterResponse find() {
        CoursesCounter coursesCounter = repository.search().orElseGet(() -> {
            throw new CoursesCounterNotInitialized();
        });

        return new CoursesCounterResponse(coursesCounter.total().value());
    }
}
