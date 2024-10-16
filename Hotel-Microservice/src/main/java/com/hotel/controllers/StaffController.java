package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entities.Staffs;
import com.hotel.payloads.StaffDTO;
import com.hotel.services.StaffServiceImpl;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffServiceImpl staffServiceImpl;
	
	@PostMapping("/save")
	public ResponseEntity<StaffDTO> create(@RequestParam String hotelId, @RequestBody StaffDTO staffDTO) {
		return ResponseEntity.ok().body(staffServiceImpl.create(hotelId,staffDTO));
	}
	
	@PutMapping
	public ResponseEntity<StaffDTO> updateStaff(@RequestBody StaffDTO staffDTO){
		return new ResponseEntity<StaffDTO>(staffServiceImpl.update(staffDTO),HttpStatus.CREATED);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<List<StaffDTO>> getStaffByHotelId (@PathVariable String hotelId){
		return ResponseEntity.ok(staffServiceImpl.get(hotelId));
	}
	
	@GetMapping
	public ResponseEntity<List<StaffDTO>> getAll(){
		return new ResponseEntity<List<StaffDTO>>(staffServiceImpl.getAll(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteStaff(@RequestParam String staffId) {
		return ResponseEntity.ok("Successfully deleted");
	}
	
}
