package com.carwash.user.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.user.models.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

//	public User findByName(String firstName);
//	public User findByEmail(String emailId);
//	public User findByLocation(String location);
}
