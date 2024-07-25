package com.recursos.platform.courses_counter.application.increment;

import com.recursos.platform.courses.domain.CourseId;
import com.recursos.platform.courses_counter.domain.CoursesCounter;
import com.recursos.platform.courses_counter.domain.CoursesCounterRepository;
import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.UuidGenerator;

@Service
public final class CoursesCounterIncrementer {
    private CoursesCounterRepository repository;
    private UuidGenerator            uuidGenerator;

    public CoursesCounterIncrementer(CoursesCounterRepository repository, UuidGenerator uuidGenerator) {
        this.repository    = repository;
        this.uuidGenerator = uuidGenerator;
    }

    public void increment(CourseId id) {
        CoursesCounter counter = repository.search()
                                           .orElseGet(() -> CoursesCounter.initialize(uuidGenerator.generate()));

        if (!counter.hasIncremented(id)) {
            counter.increment(id);

            repository.save(counter);
        }
    }
}
