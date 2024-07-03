package com.company.services_reservas_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "com.company.services_reservas_app.repositories")
public class ServicesReservasAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesReservasAppApplication.class, args);
	}

}
