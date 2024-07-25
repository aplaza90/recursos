package com.recursos.platform.shared.infrastructure.bus.event.rabbitmq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.recursos.platform.PlatformContextInfrastructureTestCase;
import com.recursos.platform.courses.domain.CourseCreatedDomainEventMother;
import com.recursos.shared.domain.course.CourseCreatedDomainEvent;
import com.recursos.shared.infrastructure.bus.event.DomainEventSubscriberInformation;
import com.recursos.shared.infrastructure.bus.event.DomainEventSubscribersInformation;
import com.recursos.shared.infrastructure.bus.event.rabbitmq.RabbitMqDomainEventsConsumer;
import com.recursos.shared.infrastructure.bus.event.rabbitmq.RabbitMqEventBus;

import java.util.Collections;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public final class RabbitMqEventBusShould extends PlatformContextInfrastructureTestCase {
    @Autowired
    private RabbitMqEventBus                      eventBus;
    @Autowired
    private RabbitMqDomainEventsConsumer          consumer;
    @Autowired
    private TestAllWorksOnRabbitMqEventsPublished subscriber;

    @BeforeEach
    protected void setUp() {
        subscriber.hasBeenExecuted = false;

        consumer.withSubscribersInformation(
            new DomainEventSubscribersInformation(
                new HashMap<Class<?>, DomainEventSubscriberInformation>() {{
                    put(TestAllWorksOnRabbitMqEventsPublished.class, new DomainEventSubscriberInformation(
                        TestAllWorksOnRabbitMqEventsPublished.class,
                        Collections.singletonList(CourseCreatedDomainEvent.class)
                    ));
                }}
            )
        );
    }

    @Test
    void publish_and_consume_domain_events_from_rabbitmq() throws Exception {
        CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.random();

        eventBus.publish(Collections.singletonList(domainEvent));

        consumer.consume();

        eventually(() -> assertTrue(subscriber.hasBeenExecuted));
    }
}
