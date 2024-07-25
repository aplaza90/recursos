package com.recursos.apps.platform.backend.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import com.recursos.shared.infrastructure.config.Parameter;
import com.recursos.shared.infrastructure.config.ParameterNotExist;

@Component
public final class PlatformBackendServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

	private final Parameter param;

	public PlatformBackendServerPortCustomizer(Parameter param) {
		this.param = param;
	}

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		try {
			factory.setPort(param.getInt("PLATFORM_BACKEND_SERVER_PORT"));
		} catch (ParameterNotExist parameterNotExist) {
			parameterNotExist.printStackTrace();
		}
	}
}
