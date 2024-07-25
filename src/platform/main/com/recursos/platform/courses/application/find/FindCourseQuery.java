package com.recursos.platform.courses.application.find;

import com.recursos.shared.domain.bus.query.Query;

public final class FindCourseQuery implements Query {
    private final String id;

    public FindCourseQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
