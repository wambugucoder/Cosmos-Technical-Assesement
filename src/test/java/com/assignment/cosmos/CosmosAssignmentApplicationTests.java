package com.assignment.cosmos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
classes =  {CosmosAssignmentApplication.class})
@ContextConfiguration(initializers = TestContainer.class)
class CosmosAssignmentApplicationTests {

    @Test
    public void contextLoads() {
    }

}