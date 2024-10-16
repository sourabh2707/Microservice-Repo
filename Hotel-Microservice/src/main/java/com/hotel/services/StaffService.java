package com.hotel.services;

import java.util.List;

import com.hotel.entities.Staffs;
import com.hotel.payloads.StaffDTO;

public interface StaffService {

	// Create
	StaffDTO create(String hotelId, StaffDTO staffDTO);

	// Update
	StaffDTO update(StaffDTO staffDTO);

	// get by hotel id
	List<StaffDTO> get(String hotelId);

	// get all
	List<StaffDTO> getAll();

	// delete by staff id
	void delete(String staffId);

}
