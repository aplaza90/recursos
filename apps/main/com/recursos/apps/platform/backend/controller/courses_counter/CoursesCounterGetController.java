package com.recursos.apps.platform.backend.controller.courses_counter;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recursos.platform.courses_counter.application.find.CoursesCounterResponse;
import com.recursos.platform.courses_counter.application.find.FindCoursesCounterQuery;
import com.recursos.shared.domain.DomainError;
import com.recursos.shared.domain.bus.command.CommandBus;
import com.recursos.shared.domain.bus.query.QueryBus;
import com.recursos.shared.domain.bus.query.QueryHandlerExecutionError;
import com.recursos.shared.infrastructure.spring.ApiController;

@RestController
public final class CoursesCounterGetController extends ApiController {

	public CoursesCounterGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/courses-counter")
	public HashMap<String, Integer> index() throws QueryHandlerExecutionError {
		CoursesCounterResponse response = ask(new FindCoursesCounterQuery());

		return new HashMap<String, Integer>() {
			{
				put("total", response.total());
			}
		};
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return null;
	}
}
