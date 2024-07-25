package com.recursos.platform.shared.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.recursos.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import com.recursos.shared.infrastructure.bus.event.rabbitmq.RabbitMqEventBus;
import com.recursos.shared.infrastructure.bus.event.rabbitmq.RabbitMqPublisher;

@Configuration
public class PlatformRabbitMqEventBusConfiguration {
    private final RabbitMqPublisher publisher;
    private final MySqlEventBus     failoverPublisher;

    public PlatformRabbitMqEventBusConfiguration(
        RabbitMqPublisher publisher,
        @Qualifier("platformMysqlEventBus") MySqlEventBus failoverPublisher
    ) {
        this.publisher         = publisher;
        this.failoverPublisher = failoverPublisher;
    }

    @Bean
    public RabbitMqEventBus platformRabbitMqEventBus() {
        return new RabbitMqEventBus(publisher, failoverPublisher);
    }
}
