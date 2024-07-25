package com.recursos.platform.courses_counter.application.find;

import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.bus.query.QueryHandler;

@Service
public final class FindCoursesCounterQueryHandler implements QueryHandler<FindCoursesCounterQuery, CoursesCounterResponse> {
    private final CoursesCounterFinder finder;

    public FindCoursesCounterQueryHandler(CoursesCounterFinder finder) {
        this.finder = finder;
    }

    @Override
    public CoursesCounterResponse handle(FindCoursesCounterQuery query) {
        return finder.find();
    }
}
