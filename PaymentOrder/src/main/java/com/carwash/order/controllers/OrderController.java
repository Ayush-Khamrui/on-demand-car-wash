package com.carwash.order.controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.carwash.order.models.Order;
import com.carwash.order.repositories.OrderRepository;
import com.carwash.order.services.OrderService;
@RestController
@RequestMapping("/payment")
public class OrderController {
	@Autowired
	private OrderService service;
	

	@PostMapping("/register")
	public ResponseEntity<String> insertOrder(@RequestBody Order order) {
		System.out.println("Order generated");
		service.addOrder(order);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteorder/{orderId}")
	public ResponseEntity<String> deleteOrderById(@PathVariable("orderId")String orderId){
		service.deleteOrder(orderId);
		return new ResponseEntity<String>("Delete-successfully",HttpStatus.OK);
	}
	

	@GetMapping("/status/{washerId}/{emailId}")
	public Order getBypayment(@PathVariable("washerId") String washerId,@PathVariable("emailId") String emailId) {
		return service.getByOrderEmail(washerId,emailId);
	}
	
}
