package com.recursos.platform.courses.infrastructure.persistence;

import com.recursos.platform.courses.domain.Course;
import com.recursos.platform.courses.domain.CourseId;
import com.recursos.platform.courses.domain.CourseRepository;
import com.recursos.shared.domain.criteria.Criteria;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public final class InMemoryCourseRepository implements CourseRepository {
    private HashMap<String, Course> courses = new HashMap<>();

    @Override
    public void save(Course course) {
        courses.put(course.id().value(), course);
    }

    public Optional<Course> search(CourseId id) {
        return Optional.ofNullable(courses.get(id.value()));
    }

    @Override
    public List<Course> matching(Criteria criteria) {
        return null;
    }
}
