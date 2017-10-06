package com.faryna.eventemitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
@SpringBootApplication
public class EventemitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventemitterApplication.class, args);
	}
}
