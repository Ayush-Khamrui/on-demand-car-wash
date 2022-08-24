package com.carwash.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.beans.factory.annotation.Autowired;

import com.carwash.user.models.User;
import com.carwash.user.repositories.UserRepository;

//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.carwash.user") //to scan packages mentioned
@EnableMongoRepositories("com.carwash.user") //to activate MongoDB repositories
//@EnableDiscoveryClient
public class UserApplication implements CommandLineRunner{
	
	private final UserRepository userRepository;
	
	// To connect the userRepository
	@Autowired
	public UserApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// Main application for user microservice
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		if(userRepository.findAll().isEmpty()) {
			userRepository.save(new User("Ayush", "Khamrui", "khamruiasok@gmail.com","Barakar","12345","Tesla"));
			userRepository.save(new User("Tuhin", "gosh", "tuhin@gmail.com","Ba","12345","Tesla model x"));
		}
		
		for(User user: userRepository.findAll()) {
			System.out.println(user);
		}
	}

}
