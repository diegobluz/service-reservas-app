package com.company.services_reservas_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com.company.services_reservas_app")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
