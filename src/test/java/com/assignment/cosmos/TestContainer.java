package com.assignment.cosmos;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import static com.assignment.cosmos.CommonFixtures.POSTGRES_DOCKER_IMAGE;


public class TestContainer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(
            POSTGRES_DOCKER_IMAGE);

    static {
        postgreSQLContainer.start();
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        TestPropertyValues.of(

                "spring.datasource.driver-class-name=org.postgresql.Driver",
                "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                "spring.datasource.password=" + postgreSQLContainer.getPassword(),
                "spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect",
                "spring.jpa.hibernate.ddl-auto=update"
        ).applyTo(applicationContext);
    }
}