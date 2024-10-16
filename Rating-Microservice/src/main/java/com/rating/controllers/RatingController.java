package com.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entities.Ratings;
import com.rating.services.RatingServiceImpl;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingServiceImpl ratingServiceImpl;
	
	@PostMapping("/save")
	public ResponseEntity<Ratings> createRating(@RequestBody Ratings rating){
		return ResponseEntity.ok().body(ratingServiceImpl.createRating(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Ratings>> getAll(){
		return ResponseEntity.ok(ratingServiceImpl.getAll());
	}
	
	@GetMapping("/getrating/{id}")
	public ResponseEntity<List<Ratings>> getByUser(@PathVariable String id){
		return ResponseEntity.ok().body(ratingServiceImpl.getByUserId(id));
	}
	
	@GetMapping("/getrating")
	public ResponseEntity<List<Ratings>> getByHotel(@RequestParam String hotelId){
		return ResponseEntity.ok().body(ratingServiceImpl.getByHotelId(hotelId));
	}
}
