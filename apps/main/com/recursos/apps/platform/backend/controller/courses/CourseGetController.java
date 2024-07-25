package com.recursos.apps.platform.backend.controller.courses;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.recursos.platform.courses.application.CourseResponse;
import com.recursos.platform.courses.application.find.FindCourseQuery;
import com.recursos.platform.courses.domain.CourseNotExist;
import com.recursos.shared.domain.DomainError;
import com.recursos.shared.domain.bus.command.CommandBus;
import com.recursos.shared.domain.bus.query.QueryBus;
import com.recursos.shared.domain.bus.query.QueryHandlerExecutionError;
import com.recursos.shared.infrastructure.spring.ApiController;

@RestController
public final class CourseGetController extends ApiController {

	public CourseGetController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@GetMapping("/courses/{id}")
	public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id)
		throws QueryHandlerExecutionError {
		CourseResponse course = ask(new FindCourseQuery(id));

		return ResponseEntity
			.ok()
			.body(
				new HashMap<String, Serializable>() {
					{
						put("id", course.id());
						put("name", course.name());
						put("duration", course.duration());
					}
				}
			);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {
			{
				put(CourseNotExist.class, HttpStatus.NOT_FOUND);
			}
		};
	}
}
