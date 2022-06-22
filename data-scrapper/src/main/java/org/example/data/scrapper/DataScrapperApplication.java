package org.example.data.scrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DataScrapperApplication {

	public static void main(String[] args) {

		SpringApplication.run(DataScrapperApplication.class, args);
	}
}
