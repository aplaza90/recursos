package com.recursos.platform.shared.infrastructure.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.recursos.shared.infrastructure.config.Parameter;
import com.recursos.shared.infrastructure.config.ParameterNotExist;
import com.recursos.shared.infrastructure.hibernate.HibernateConfigurationFactory;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class PlatformHibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final Parameter                     config;
    private final String                        CONTEXT_NAME = "platform";

    public PlatformHibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config  = config;
    }

    @Bean("platform-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("platform-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("platform-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            config.get("PLATFORM_DATABASE_HOST"),
            config.getInt("PLATFORM_DATABASE_PORT"),
            config.get("PLATFORM_DATABASE_NAME"),
            config.get("PLATFORM_DATABASE_USER"),
            config.get("PLATFORM_DATABASE_PASSWORD")
        );
    }
}
