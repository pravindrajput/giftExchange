package com.microservice.gitexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMicroserviceGiftExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceGiftExchangeServiceApplication.class, args);
	}
}
