package com.mas.quotation.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@Configuration
public class SwaggerConfig {
	public OpenAPI springOpenApi() {
		return new OpenAPI().info(new Info().title("Logistics")
				.description("Rest API for Logistics")
				.version("1.0")
				.termsOfService("Terms of service")
				.contact(contact())
				.license(license())
				.extensions(Collections.emptyMap()));
	}
	
	private Contact contact() {
		return new io.swagger.v3.oas.models.info.Contact()
		.name("Logistics")
		.url("https://main.d1mbvmnvdsl5ew.amplifyapp.com/")
		.extensions(Collections.emptyMap());
	}
	
	private License license() {
		return new License()
				.name("Logistics")
				.url("https://main.d1mbvmnvdsl5ew.amplifyapp.com/")
				.extensions(Collections.emptyMap());
	}
}
