package com.hotel.payloads;

import java.util.List;

import com.hotel.entities.Staffs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
	private String hotelId;
	private String name;
	private List<StaffDTO> staff;
}
