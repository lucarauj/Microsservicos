package br.com.people.control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PeopleControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleControlApplication.class, args);
	}

}
