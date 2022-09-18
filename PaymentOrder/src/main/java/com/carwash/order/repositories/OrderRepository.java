package com.carwash.order.repositories;

import java.util.List;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carwash.order.models.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {
		
		@Query("{washerId: ?0, email: ?1}")  
		Order findByPay(String washerId, String eamilId);
		
}
