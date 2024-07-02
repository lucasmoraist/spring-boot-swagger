package com.lucasmoraist.spring_boot_swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI documentation() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot Swagger API")
                        .description("""
                               Esta API é destinada para prática de documentação com Swagger em um projeto Spring Boot
                               onde pode ser feito o gerenciamento de dados de uma pessoa
                               """)
                        .summary("Está API serve para fazer o gerenciamento de dados de uma pessoa.")
                        .version("V1")
                        .contact(new Contact()
                                .name("Lucas de Morais Nascimento Taguchi")
                                .url("https://lucasmoraist.github.io/Portfolio/")
                                .email("luksmnt1101@gmail.com")
                        )
                        .license(new License()
                                .name("")
                                .identifier("")
                                .url("")
                        )
                );
    }

}
