package br.com.descomplica.projeto2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringdocConfig {
    @Bean
        public OpenAPI springShOpenAPI(){
            return new OpenAPI()
                .info(new Info().title("API Restful com documentação - Exercício Pensar e Responder 06 - ADS Descomplica")
                .description("Exemplo simples de API Restful para registro turmas e instrutores. Documentada com uso de depências Springdoc. Um instrutor pode ter várias turmas, e cada turma só pode ter um instrutor.")
                .version("1.0.0"));
        }

}