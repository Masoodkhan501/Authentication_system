package com.masood.services;

import com.masood.dtos.userDTO;

public interface userService {
	public userDTO createUser(userDTO user);
	
	public userDTO getUserByEmail(String email);
	
	public userDTO updateUser(userDTO userDto, String userId);
	
	public void deleteUser(String userId);
	
	public userDTO getUserByID(String userId);
	
	Iterable<userDTO> getAllUsers();
}
