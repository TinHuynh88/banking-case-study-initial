package com.example.banking.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrchestratorConfig {

    @Bean
    public RestTemplate getTemplate(){

        RestTemplate template = new RestTemplate();

        return template;
    }
}
