package com.wallet.wallet.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Portfolio API REST",
        version = "v1",
        description = "Documentación de la API REST Portfolio"
))
public class SpringDocConfig {
}