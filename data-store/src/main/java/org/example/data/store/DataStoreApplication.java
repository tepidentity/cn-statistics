package org.example.data.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@ConfigurationPropertiesScan
public class DataStoreApplication {

	public static void main(String[] args) {

		SpringApplication.run(DataStoreApplication.class, args);
	}
}
