package org.example.statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class StatisticsApplication {

	public static void main(String[] args) {

		SpringApplication.run(StatisticsApplication.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {

		return new RestTemplate();
	}
}
