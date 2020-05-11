package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserProfileMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProfileMicroserviceApplication.class, args);
	}

}
