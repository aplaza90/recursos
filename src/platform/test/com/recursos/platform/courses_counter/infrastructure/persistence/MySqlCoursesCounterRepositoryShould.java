package com.recursos.platform.courses_counter.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import com.recursos.platform.courses_counter.CoursesCounterModuleInfrastructureTestCase;
import com.recursos.platform.courses_counter.domain.CoursesCounter;
import com.recursos.platform.courses_counter.domain.CoursesCounterMother;

import jakarta.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
class MySqlCoursesCounterRepositoryShould extends CoursesCounterModuleInfrastructureTestCase {
    @Test
    void return_an_existing_courses_counter() {
        CoursesCounter counter = CoursesCounterMother.random();

        repository.save(counter);

        assertEquals(Optional.of(counter), repository.search());
    }
}
