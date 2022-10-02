package com.assignment.cosmos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cosmos Test API", version = "1.0", description = "API playground for Cosmos Test"))
public class CosmosAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CosmosAssignmentApplication.class, args);
    }

}