package com.recursos.platform.shared.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.recursos.shared.infrastructure.bus.event.DomainEventsInformation;
import com.recursos.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import com.recursos.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import com.recursos.shared.infrastructure.bus.event.spring.SpringApplicationEventBus;

@Configuration
public class PlatformMySqlEventBusConfiguration {
    private final SessionFactory            sessionFactory;
    private final DomainEventsInformation   domainEventsInformation;
    private final SpringApplicationEventBus bus;

    public PlatformMySqlEventBusConfiguration(
        @Qualifier("platform-session_factory") SessionFactory sessionFactory,
        DomainEventsInformation domainEventsInformation,
        SpringApplicationEventBus bus
    ) {
        this.sessionFactory          = sessionFactory;
        this.domainEventsInformation = domainEventsInformation;
        this.bus                     = bus;
    }

    @Bean
    public MySqlEventBus platformMysqlEventBus() {
        return new MySqlEventBus(sessionFactory);
    }

    @Bean
    public MySqlDomainEventsConsumer platformMySqlDomainEventsConsumer() {
        return new MySqlDomainEventsConsumer(sessionFactory, domainEventsInformation, bus);
    }
}
