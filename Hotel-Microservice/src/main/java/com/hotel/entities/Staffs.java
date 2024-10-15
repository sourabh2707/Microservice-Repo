package com.hotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="StaffData")
public class Staffs {

	@jakarta.persistence.Id
	private String staffId;
	private String name;
	@OneToOne
    private Hotels hotels;
	
	
}
