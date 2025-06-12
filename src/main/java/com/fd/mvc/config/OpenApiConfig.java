package com.fd.mvc.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI adminSpringBootOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AdminSpringBoot API")
                        .description("Documentación de los servicios disponibles")
                        .version("1.0"));
    }
}
