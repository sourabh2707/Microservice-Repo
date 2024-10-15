package com.rating.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rating.entities.Ratings;

public interface RatingService {

	// Save rating
	Ratings createRating(Ratings rating);

	// Get all ratings
	List<Ratings> getAll();

	// Get all ratings by user id
	List<Ratings> getByUserId(String userId);

	// Get all ratings by hotel id
	List<Ratings> getByHotelId(String hotelId);

}
