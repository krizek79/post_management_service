package com.krizan.post_management_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Post API"))
public class PostManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostManagementApplication.class, args);
    }

}
