package com.rating.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rating.entities.Ratings;
import com.rating.repositories.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Ratings createRating(Ratings rating) {

		return ratingRepository.save(rating);
	}

	@Override
	public List<Ratings> getAll() {

		return ratingRepository.findAll();
	}

	@Override
	public List<Ratings> getByUserId(String userId) {

		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Ratings> getByHotelId(String hotelId) {

		return ratingRepository.findByHotelId(hotelId);
	}

}
