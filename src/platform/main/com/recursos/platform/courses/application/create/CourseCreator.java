package com.recursos.platform.courses.application.create;

import com.recursos.platform.courses.domain.*;
import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.bus.event.EventBus;

@Service
public final class CourseCreator {
    private final CourseRepository repository;
    private final EventBus         eventBus;

    public CourseCreator(CourseRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus   = eventBus;
    }

    public void create(String id, String name, String duration) {


        Course course = Course.create(
                new CourseId(id),
                new CourseName(name),
                new CourseDuration(duration)
        );

        repository.save(course);
        eventBus.publish(course.pullDomainEvents());
    }
}
