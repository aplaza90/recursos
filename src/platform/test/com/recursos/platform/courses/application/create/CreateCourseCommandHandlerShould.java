package com.recursos.platform.courses.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.recursos.platform.courses.CoursesModuleUnitTestCase;
import com.recursos.platform.courses.domain.Course;
import com.recursos.platform.courses.domain.CourseCreatedDomainEventMother;
import com.recursos.platform.courses.domain.CourseMother;
import com.recursos.shared.domain.course.CourseCreatedDomainEvent;

final class CreateCourseCommandHandlerShould extends CoursesModuleUnitTestCase {
    private CreateCourseCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new CreateCourseCommandHandler(new CourseCreator(repository, eventBus));
    }

    @Test
    void create_a_valid_course() {
        CreateCourseCommand command = CreateCourseCommandMother.random();

        Course                   course      = CourseMother.fromRequest(command);
        CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.fromCourse(course);

        handler.handle(command);

        shouldHaveSaved(course);
        shouldHavePublished(domainEvent);
    }
}
