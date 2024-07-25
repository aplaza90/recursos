package com.recursos.apps.platform.backend;

import java.util.HashMap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.recursos.apps.platform.backend.command.ConsumeMySqlDomainEventsCommand;
import com.recursos.apps.platform.backend.command.ConsumeRabbitMqDomainEventsCommand;
import com.recursos.shared.domain.Service;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
	includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
	value = { "com.recursos.shared", "com.recursos.platform", "com.recursos.apps.platform.backend"}
)
public class PlatformBackendApplication {

	public static HashMap<String, Class<?>> commands() {
		return new HashMap<String, Class<?>>() {
			{
				put("domain-events:mysql:consume", ConsumeMySqlDomainEventsCommand.class);
				put("domain-events:rabbitmq:consume", ConsumeRabbitMqDomainEventsCommand.class);
			}
		};
	}
}
