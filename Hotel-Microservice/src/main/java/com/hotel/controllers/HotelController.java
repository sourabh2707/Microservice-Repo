package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entities.Hotels;
import com.hotel.payloads.HotelDTO;
import com.hotel.services.HotelServiceImpl;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelServiceImpl hotelServiceImpl;

	@PostMapping("/save")
	public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDTO) {
		HotelDTO dto = hotelServiceImpl.createHotel(hotelDTO);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping
	public ResponseEntity<List<HotelDTO>> getAll() {
		return ResponseEntity.ok().body(hotelServiceImpl.getHotels());
	}

	@GetMapping("/gethotel")
	public ResponseEntity<HotelDTO> getHotel(@RequestParam String id) {
		return ResponseEntity.ok(hotelServiceImpl.getHotel(id));
	}
}
