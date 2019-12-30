package com.restMicroCrud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCrudApplication.class, args);
	}

}
