package com.projectcms.cms;



import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "API Documentation for Candidate Management System",
				version = "1.0",
				description = "API documentation for Candidate Management System and Job Portal"
		)
)
@SpringBootApplication
public class SwaggerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}
}
