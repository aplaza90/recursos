package com.recursos.apps.platform.backend.command;

import com.recursos.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import com.recursos.shared.infrastructure.cli.ConsoleCommand;

public final class ConsumeMySqlDomainEventsCommand extends ConsoleCommand {

	private final MySqlDomainEventsConsumer consumer;

	public ConsumeMySqlDomainEventsCommand(MySqlDomainEventsConsumer consumer) {
		this.consumer = consumer;
	}

	@Override
	public void execute(String[] args) {
		consumer.consume();
	}
}
