package com.recursos.platform.courses.application.find;

import com.recursos.platform.courses.application.CourseResponse;
import com.recursos.platform.courses.domain.CourseId;
import com.recursos.platform.courses.domain.CourseNotExist;
import com.recursos.platform.courses.domain.CourseRepository;
import com.recursos.shared.domain.Service;

@Service
public final class CourseFinder {
    private final CourseRepository repository;

    public CourseFinder(CourseRepository repository) {
        this.repository = repository;
    }

    public CourseResponse find(CourseId id) throws CourseNotExist {
        return repository.search(id)
                         .map(CourseResponse::fromAggregate)
                         .orElseThrow(() -> new CourseNotExist(id));
    }
}
