package br.com.animal.control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AnimalControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(br.com.animal.control.AnimalControlApplication.class, args);
	}

}
