package com.recursos.platform;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import com.recursos.apps.platform.backend.PlatformBackendApplication;
import com.recursos.shared.infrastructure.InfrastructureTestCase;

@ContextConfiguration(classes = PlatformBackendApplication.class)
@SpringBootTest
public abstract class PlatformContextInfrastructureTestCase extends InfrastructureTestCase {
}
