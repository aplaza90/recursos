package com.recursos.apps.platform.backend.controller.health_check;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recursos.shared.domain.DomainError;
import com.recursos.shared.domain.bus.command.CommandBus;
import com.recursos.shared.domain.bus.query.QueryBus;
import com.recursos.shared.infrastructure.spring.ApiController;


@RestController
public final class HealthCheckGetController extends ApiController {

	public HealthCheckGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	private static final Logger logger = LogManager.getLogger(HealthCheckGetController.class);

	@GetMapping("/health-check")
	public HashMap<String, String> index() {
		HashMap<String, String> status = new HashMap<>();
		status.put("application", "platform_backend");
		status.put("status", "ok");

		logger.warn("This is a test log info message");

		return status;
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return null;
	}

}
