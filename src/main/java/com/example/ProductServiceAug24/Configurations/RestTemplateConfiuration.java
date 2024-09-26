package com.example.ProductServiceAug24.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiuration {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
