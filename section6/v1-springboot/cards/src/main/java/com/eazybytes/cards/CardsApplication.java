package com.eazybytes.cards;

import com.eazybytes.cards.dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice REST API documentation",
				description = "EazyBank Cards microservice REST API documentation",
				version = "v1",
				contact = @Contact(
						name = "Sheetal Kabra",
						email = "sheetalkabra4@gmail.com",
						url = "https://sheetalkabra.com/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://localhost:9000/swagger-ui/"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "EazyBank Cards microservice REST API documentation",
				url = "http://localhost:9000/swagger-ui/"
		)
)
@EnableConfigurationProperties({CardsContactInfoDto.class})
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
