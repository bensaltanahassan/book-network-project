package com.bensaltana.book.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Bensaltana Hassan",
                        email = "bensaltanahassan@gmail.com",
                        url = "https://github.com/bensaltanahassan"
                ),
                description = "Book Store API Documentation With Spring Boot",
                title = "Book Store API",
                version = "1.0.0",
                license = @License(
                        name = "Free License",
                        url = "https://github.com/bensaltanahassan"
                ),
                termsOfService = "Terms of Service"
        ),
        servers = {
                @Server(
                description = "Local ENV",
                url = "http://localhost:8088/api/v1"
            ),
                @Server(
                        description = "Production ENV",
                        url = "https://api.bensaltana.com/api/v1"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
