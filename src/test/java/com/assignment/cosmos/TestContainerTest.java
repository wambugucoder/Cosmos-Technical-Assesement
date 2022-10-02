package com.assignment.cosmos;

import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
public class TestContainerTest {

    @Test
    void test_container_deployment() {
        assertTrue(TestContainer.postgreSQLContainer.isCreated());
        assertTrue(TestContainer.postgreSQLContainer.isRunning());
    }

    @Test
    void test_container_stopped() {
        TestContainer.postgreSQLContainer.stop();
        assertFalse(TestContainer.postgreSQLContainer.isRunning());
    }
}