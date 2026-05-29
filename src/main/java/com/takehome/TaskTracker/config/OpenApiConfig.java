package com.takehome.TaskTracker.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI taskTrackerOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Task Tracker API")
                        .description("Project and Task Management Service")
                        .version("1.0"));
    }
}