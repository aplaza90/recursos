package com.recursos.platform.courses.application.find;

import com.recursos.platform.courses.application.CourseResponse;
import com.recursos.platform.courses.domain.CourseId;
import com.recursos.platform.courses.domain.CourseNotExist;
import com.recursos.shared.domain.Service;
import com.recursos.shared.domain.bus.query.QueryHandler;

@Service
public final class FindCourseQueryHandler implements QueryHandler<FindCourseQuery, CourseResponse> {
    private final CourseFinder finder;

    public FindCourseQueryHandler(CourseFinder finder) {
        this.finder = finder;
    }

    @Override
    public CourseResponse handle(FindCourseQuery query) throws CourseNotExist {
        return finder.find(new CourseId(query.id()));
    }
}
