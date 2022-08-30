package com.carwash.washer.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carwash.washer.models.Washer;

@Repository
public interface WasherRepository extends MongoRepository<Washer,String>{
	
	@Query("{'emailId' : :#{#emailId}}")
	Optional<Washer> findByEmail(@Param("emailId")String emailId);

}
