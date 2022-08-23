package com.carwash.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
//@EnableSwagger2
@ComponentScan("com.carwash.user") //to scan packages mentioned
@EnableMongoRepositories("com.carwash.user") //to activate MongoDB repositories
public class UserApplication implements CommandLineRunner{
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	
//	@Bean
//	   public Docket productApi() {
//	      return new Docket(DocumentationType.SWAGGER_2).select()
//	         .apis(RequestHandlerSelectors.basePackage("com.carwash.user")).build();
//	   }

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
