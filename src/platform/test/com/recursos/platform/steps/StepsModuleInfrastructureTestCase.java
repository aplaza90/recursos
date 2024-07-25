package com.recursos.platform.steps;

import org.springframework.beans.factory.annotation.Autowired;
import com.recursos.platform.PlatformContextInfrastructureTestCase;
import com.recursos.platform.steps.domain.StepRepository;

public abstract class StepsModuleInfrastructureTestCase extends PlatformContextInfrastructureTestCase {
    @Autowired
    protected StepRepository repository;
}
