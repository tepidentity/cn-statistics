package org.example.data.scrapper.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@Configuration
public class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate() {

        return new RestTemplate(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
    }
}
