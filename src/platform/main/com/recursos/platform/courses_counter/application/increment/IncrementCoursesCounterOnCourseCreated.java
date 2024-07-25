package com.recursos.platform.courses_counter.application.increment;

import org.springframework.context.event.EventListener;
import com.recursos.platform.courses.domain.CourseId;
import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.bus.event.DomainEventSubscriber;
import com.recursos.shared.domain.course.CourseCreatedDomainEvent;

@Service
@DomainEventSubscriber({CourseCreatedDomainEvent.class})
public final class IncrementCoursesCounterOnCourseCreated {
    private final CoursesCounterIncrementer incrementer;

    public IncrementCoursesCounterOnCourseCreated(CoursesCounterIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    @EventListener
    public void on(CourseCreatedDomainEvent event) {
        CourseId courseId = new CourseId(event.aggregateId());

        incrementer.increment(courseId);
    }
}
