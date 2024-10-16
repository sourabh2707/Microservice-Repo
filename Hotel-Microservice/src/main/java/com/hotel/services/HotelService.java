package com.hotel.services;

import java.util.List;

import com.hotel.entities.Hotels;
import com.hotel.payloads.HotelDTO;

public interface HotelService {

	// Save hotel
	HotelDTO createHotel(HotelDTO hotelDTO);

	// Get hotel list
	List<HotelDTO> getHotels();

	// Get hotel
	HotelDTO getHotel(String id);
}
