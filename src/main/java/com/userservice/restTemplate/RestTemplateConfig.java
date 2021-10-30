package com.userservice.restTemplate;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateConfig {


    @Bean

    public RestTemplate restTemplate() {
        RestTemplate restTemplate= new RestTemplate();
        DefaultUriBuilderFactory builderFactory= new DefaultUriBuilderFactory("http://localhost:6060/order");
        restTemplate.setUriTemplateHandler(builderFactory);
        return restTemplate;
    }
}
