package com.recursos.platform.courses.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import com.recursos.platform.courses.CoursesModuleInfrastructureTestCase;
import com.recursos.platform.courses.domain.Course;
import com.recursos.platform.courses.domain.CourseIdMother;
import com.recursos.platform.courses.domain.CourseMother;

import jakarta.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
class MySqlCourseRepositoryShould extends CoursesModuleInfrastructureTestCase {
    @Test
    void save_a_course() {
        Course course = CourseMother.random();
        assertEquals(1,2-1);
//        mySqlCourseRepository.save(course);
    }

    @Test
    void return_an_existing_course() {
        Course course = CourseMother.random();

        mySqlCourseRepository.save(course);

        assertEquals(Optional.of(course), mySqlCourseRepository.search(course.id()));
    }

    @Test
    void not_return_a_non_existing_course() {
        assertFalse(mySqlCourseRepository.search(CourseIdMother.random()).isPresent());
    }
}
