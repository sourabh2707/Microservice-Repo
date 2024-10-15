package com.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.entities.Staffs;

@Repository
public interface StaffRepository extends JpaRepository<Staffs, String> {


	// Can write native queries like this
	@Query(value = "select * from Staffs where hotelId=?1", nativeQuery = true)
	public List<Staffs> findByHotelId(String hotels_hotel_id);

}
