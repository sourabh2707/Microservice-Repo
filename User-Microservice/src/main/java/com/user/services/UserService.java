package com.user.services;

import java.util.List;

import com.user.entities.Users;

public interface UserService {

	// Create user
	Users createUser(Users user);

	// Get user list
	List<Users> allUsers();

	// Get user by id
	Users getUser(String id);
}
