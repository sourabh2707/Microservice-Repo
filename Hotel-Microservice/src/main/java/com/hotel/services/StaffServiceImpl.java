package com.hotel.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	  @Autowired private ModelMapper modelMapper;
	 

	@Override
	public StaffDTO create(String hotelId, StaffDTO staffDTO) {
		String id = UUID.randomUUID().toString();
		staffDTO.setStaffId(id);
		Hotels hotels = hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException(String.format("Hotel id : %s not found on server", hotelId)));
		Staffs staffs = modelMapper.map(staffDTO, Staffs.class);
		staffs.setHotels(hotels);
		StaffDTO dto = modelMapper.map(staffs, StaffDTO.class);
		return dto;
	}

	@Override
	public StaffDTO update(StaffDTO staffDTO) {
		
		Staffs staffs = staffRepository.findById(staffDTO.getStaffId()).orElseThrow(() -> new ResourceNotFoundException(
				String.format("Resource with user id %s not found on server", staffDTO.getStaffId())));
		staffs.setName(staffs.getName());
		staffs.setHotels(staffs.getHotels());
		StaffDTO dto = modelMapper.map(staffRepository.save(staffs), StaffDTO.class);
		return dto;
	}

	@Override
	public List<StaffDTO> get(String hotelId) {
		List<Staffs> list = staffRepository.findByHotelId(hotelId);
		List<StaffDTO> dtoList = list.stream().map(i->modelMapper.map(i, StaffDTO.class)).collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public List<StaffDTO> getAll() {
	List <Staffs> list = staffRepository.findAll();
	List<StaffDTO> dto = list.stream().map(staffList->modelMapper.map(list, StaffDTO.class)).collect(Collectors.toList());
		return dto;
	}

	@Override
	public void delete(String staffId) {
		staffRepository.deleteById(staffId); 
	}

}
