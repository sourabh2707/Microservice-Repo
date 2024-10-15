package com.user.userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.user.entities.Ratings;
import com.user.entities.Users;
import com.user.repositories.UserRepository;
import com.user.services.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Mock
	private UserRepository userRepository;

	@Test
	public void createUserTest() {

		Users users = new Users();
		users.setUserId("njnkd25315dsas");
		users.setName("Test");
		users.setEmail("test@gmail.com");
		when(userRepository.save(users)).thenReturn(users);
		assertEquals(users, userServiceImpl.createUser(users));
	}

	@Test
	public void findAllTest() {
		List<Users> listUsers = new ArrayList<>();
		Users users = new Users();
		users.setUserId("hjbnlads3153");
		users.setName("test1");
		users.setEmail("njnjsn@gmail.com");
		users.setUserId("un5sbjundjn5");
		users.setName("test2");
		users.setEmail("kmbbds@gmail.com");
		
		when(userRepository.findAll()).thenReturn(listUsers);
		assertEquals(listUsers, userServiceImpl.allUsers());
	}

}
