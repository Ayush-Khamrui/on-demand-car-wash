package com.carwash.user.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.carwash.user.models.User;
import com.carwash.user.repositories.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/getall")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> insertProduct(@RequestBody User user) {
		System.out.println("User registered");
		userRepository.save(user);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteuser/{emailId}")
	public ResponseEntity<String> deletestudentById(@PathVariable("emailId")String emailId){
		userRepository.deleteById(emailId);
		return new ResponseEntity<String>("Delete-successfully",HttpStatus.OK);
	}
	
}
