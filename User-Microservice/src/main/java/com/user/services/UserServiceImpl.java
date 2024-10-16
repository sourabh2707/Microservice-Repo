package com.user.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entities.Hotels;
import com.user.entities.Ratings;
import com.user.entities.Users;
import com.user.exceptions.ResourceNotFoundException;
import com.user.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public Users createUser(Users user) {
		String randomUUID = UUID.randomUUID().toString();
		user.setUserId(randomUUID);
		Users user1 = userRepository.save(user);
		return user1;
	}

	@Override
	public List<Users> allUsers() {
		// Getting all users
		List<Users> usersList = userRepository.findAll();
		logger.info("Getting user list");
		// Using forEach iterating usersList and for every user getting the ratings from
		// rating micro-service using rest template and setting that rating to user
		usersList.stream().forEach(i -> {
			ArrayList<Ratings> ratingList = restTemplate
					.getForObject("http://RATING-MICROSERVICE/rating/getrating/" + i.getUserId(), ArrayList.class);
			i.setRatings(ratingList);
		});

		return usersList;
	}

	@Override
	public Users getUser(String id) {
		// Finding user by user id
		Users user = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User with the given user id not found on server:" + id));

		// With help of rest template calling ratings api which gets rating by userid
		Ratings[] ratings = restTemplate
				.getForObject("http://RATING-MICROSERVICE/rating/getrating/" + user.getUserId(), Ratings[].class);
		List<Ratings> ratingList= Arrays.asList(ratings);
		// Using log4j to display the object
		logger.info("{}", ratingList);
		// Setting the ratings to user
		user.setRatings(ratingList);
		
		//http://localhost:8081/hotel/gethotel?id=25bc5038-4a40-4069-88f9-a81be599ae1a
		
		List<Ratings> list = ratingList.stream().map((i)->{
		Hotels hotel = restTemplate.getForObject("http://HOTEL-MICROSERVICE/hotel/gethotel?id="+i.getHotelId(), Hotels.class);
		i.setHotels(hotel);
		return i;
		}).collect(Collectors.toList());
		user.setRatings(list);
		return user;
	}

}
