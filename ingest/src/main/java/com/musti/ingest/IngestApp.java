package com.musti.ingest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(scanBasePackages={"com.musti.ingest"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class IngestApp {

	public static void main(String[] args) {
		SpringApplication.run(IngestApp.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
