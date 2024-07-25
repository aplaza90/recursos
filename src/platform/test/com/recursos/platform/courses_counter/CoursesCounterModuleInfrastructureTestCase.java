package com.recursos.platform.courses_counter;

import org.springframework.beans.factory.annotation.Autowired;
import com.recursos.platform.PlatformContextInfrastructureTestCase;
import com.recursos.platform.courses_counter.domain.CoursesCounterRepository;

public abstract class CoursesCounterModuleInfrastructureTestCase extends PlatformContextInfrastructureTestCase {
    @Autowired
    protected CoursesCounterRepository repository;
}
