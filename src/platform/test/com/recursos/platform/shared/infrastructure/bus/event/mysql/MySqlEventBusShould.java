package com.recursos.platform.shared.infrastructure.bus.event.mysql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.recursos.platform.PlatformContextInfrastructureTestCase;
import com.recursos.platform.courses.domain.CourseCreatedDomainEventMother;
import com.recursos.shared.domain.course.CourseCreatedDomainEvent;
import com.recursos.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import com.recursos.shared.infrastructure.bus.event.mysql.MySqlEventBus;

import jakarta.transaction.Transactional;
import java.util.Collections;

@Transactional
class MySqlEventBusShould extends PlatformContextInfrastructureTestCase {
    @Autowired
    private MySqlEventBus             eventBus;
    @Autowired
    private MySqlDomainEventsConsumer consumer;

    @Test
    void publish_and_consume_domain_events_from_msql() throws InterruptedException {
        CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.random();

        eventBus.publish(Collections.singletonList(domainEvent));

        Thread consumerProcess = new Thread(() -> consumer.consume());
        consumerProcess.start();

        Thread.sleep(100);

        consumer.stop();
    }
}
