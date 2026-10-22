package com.masood.services;

import com.masood.dtos.user.CreateUserDTO;
import com.masood.dtos.user.ResponseUserDTO;
import com.masood.dtos.user.UpdateUserDTO;

public interface userService {
	public ResponseUserDTO createUser(CreateUserDTO user);
	
	public ResponseUserDTO getUserByEmail(String email);
	
	public ResponseUserDTO updateUser(UpdateUserDTO userDto, String userId);
	
	public void deleteUser(String userId);
	
	public CreateUserDTO getUserByID(String userId);
	
	Iterable<ResponseUserDTO> getAllUsers();
}
