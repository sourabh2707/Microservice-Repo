package com.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.user.entities.Users;
import com.user.services.UserServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@ApiOperation(value = "Save the user", httpMethod = "Post")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 405, message = "Method not allowed") })
	@PostMapping("/save")
	public ResponseEntity<Users> createUser(@RequestBody Users user) {
		Users user1 = userServiceImpl.createUser(user);
		return ResponseEntity.ok().body(user1);
	}

	@ApiOperation(value = "Get all users", httpMethod = "Get")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 405, message = "Method not allowed") })
	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> userList = userServiceImpl.allUsers();
		return ResponseEntity.ok().body(userList);
	}

	@ApiOperation(value = "Get user", httpMethod = "Get")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 402, message = "User not found") })
	@GetMapping("/{id}")
	public ResponseEntity<Users> getUser(@PathVariable("id") String userId) {
		Users user1 = userServiceImpl.getUser(userId);
		return ResponseEntity.ok(user1);
	}
}
