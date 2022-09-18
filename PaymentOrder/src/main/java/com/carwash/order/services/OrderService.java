package com.carwash.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.order.models.Order;
import com.carwash.order.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	
	public Order addOrder(Order order) {
		return repository.save(order);
	}
	
	
	public void deleteOrder(String orderId) {
		repository.deleteById(orderId);
	}


	public Order getByOrderEmail(String washerId,String emailId) {
		return repository.findByPay(washerId,emailId);
	}

	
}
