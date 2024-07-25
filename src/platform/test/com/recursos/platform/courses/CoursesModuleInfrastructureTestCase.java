package com.recursos.platform.courses;

import org.springframework.beans.factory.annotation.Autowired;
import com.recursos.platform.PlatformContextInfrastructureTestCase;
import com.recursos.platform.courses.domain.CourseRepository;
import com.recursos.platform.courses.infrastructure.persistence.InMemoryCourseRepository;

public abstract class CoursesModuleInfrastructureTestCase extends PlatformContextInfrastructureTestCase {
    protected InMemoryCourseRepository inMemoryCourseRepository = new InMemoryCourseRepository();
    @Autowired
    protected CourseRepository         mySqlCourseRepository;
}
