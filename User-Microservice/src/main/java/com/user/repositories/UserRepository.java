package com.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String>{

}
