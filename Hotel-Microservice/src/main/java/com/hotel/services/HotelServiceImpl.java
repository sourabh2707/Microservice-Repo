package com.hotel.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entities.Hotels;
import com.hotel.entities.Staffs;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.payloads.HotelDTO;
import com.hotel.payloads.StaffDTO;
import com.hotel.repositories.HotelRepository;
import com.hotel.repositories.StaffRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public HotelDTO createHotel(HotelDTO hotelDTO) {
		String id = UUID.randomUUID().toString();
		hotelDTO.setHotelId(id);
		Hotels hotel = modelMapper.map(hotelDTO, Hotels.class);
		HotelDTO dto = modelMapper.map(hotelRepository.save(hotel), HotelDTO.class);
		return dto;
	}

	@Override
	public List<HotelDTO> getHotels() {
		List<Hotels> hotelList = hotelRepository.findAll();
		/*
		 * List<Hotels> updatedList = hotelList.stream().map(hotel -> { String id =
		 * hotel.getHotelId(); List<Staffs> staff = staffRepository.findByHotelId(id);
		 * if (staff != null) { hotel.setStaffs(staff); return hotel; } else { return
		 * hotel; } }).collect(Collectors.toList()); return updatedList;
		 */
		
		List<HotelDTO> hotelDTOList = hotelList.stream().map(i -> {
			List<StaffDTO> staffDTO = i.getStaff().stream().map(staff-> modelMapper.map(staff, StaffDTO.class)).collect(Collectors.toList()); 
			
			HotelDTO hotelDTO = modelMapper.map(i, HotelDTO.class);
			hotelDTO.setStaff(staffDTO);
			return hotelDTO;
		}).collect(Collectors.toList());
		return hotelDTOList;
	}

	@Override
	public HotelDTO getHotel(String id) {
		Hotels hotel = hotelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with user id not found on server:" + id));
		HotelDTO hotelDTO = modelMapper.map(hotel, HotelDTO.class);
		return hotelDTO;
	}
}
