// src/main/java/com/miapi/apiventas/config/swagger/SwaggerConfig.java
package com.miapi.apiventas.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Ventas")
                .version("1.0")
                .description("Documentación de la API de gestión de categorías"));
    }
}