package com.hotel.entities;

import java.util.List;

import com.hotel.payloads.StaffDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HotelsData")
public class Hotels {
	@Id
	@Column(name = "HotelId")
	private String hotelId;
	@Column(name = "Name")
	private String name;
	@OneToMany(mappedBy="hotels")
	private List<Staffs> staff;
}
