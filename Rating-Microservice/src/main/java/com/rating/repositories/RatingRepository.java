package com.rating.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rating.entities.Ratings;

@Repository
public interface RatingRepository extends MongoRepository<Ratings, String>{

	List<Ratings> findByUserId(String userId);
	
	List<Ratings> findByHotelId(String hotelId);
}
