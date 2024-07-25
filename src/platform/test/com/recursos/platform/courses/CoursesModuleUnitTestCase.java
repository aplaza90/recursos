package com.recursos.platform.courses;

import org.junit.jupiter.api.BeforeEach;
import com.recursos.platform.courses.domain.Course;
import com.recursos.platform.courses.domain.CourseRepository;
import com.recursos.shared.infrastructure.UnitTestCase;

import static org.mockito.Mockito.*;

public abstract class CoursesModuleUnitTestCase extends UnitTestCase {
    protected CourseRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(CourseRepository.class);
    }

    public void shouldHaveSaved(Course course) {
        verify(repository, atLeastOnce()).save(course);
    }
}
