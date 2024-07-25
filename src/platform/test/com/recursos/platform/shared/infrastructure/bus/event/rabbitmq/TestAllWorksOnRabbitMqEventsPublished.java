package com.recursos.platform.shared.infrastructure.bus.event.rabbitmq;

import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.bus.event.DomainEventSubscriber;
import com.recursos.shared.domain.course.CourseCreatedDomainEvent;

@Service
@DomainEventSubscriber({CourseCreatedDomainEvent.class})
public final class TestAllWorksOnRabbitMqEventsPublished {
    public Boolean hasBeenExecuted = false;

    public void on(CourseCreatedDomainEvent event) {
        hasBeenExecuted = true;
    }
}
