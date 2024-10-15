package com.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entities.Hotels;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, String>{

}
