package com.recursos.platform.courses.application.search_last;

import com.recursos.platform.courses.application.CourseResponse;
import com.recursos.platform.courses.application.CoursesResponse;
import com.recursos.platform.courses.domain.CourseRepository;
import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.criteria.Criteria;
import com.recursos.shared.domain.criteria.Filters;
import com.recursos.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class LastCoursesSearcher {
    private final CourseRepository repository;

    public LastCoursesSearcher(CourseRepository repository) {
        this.repository = repository;
    }

    public CoursesResponse search(int courses) {
        Criteria criteria = new Criteria(
            Filters.none(),
            Order.none(),
            Optional.of(courses),
            Optional.empty()
        );

        return new CoursesResponse(
            repository.matching(criteria).stream().map(CourseResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
