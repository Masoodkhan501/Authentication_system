package com.masood.services;

import org.springframework.stereotype.Service;

import com.masood.dtos.userDTO;
import com.masood.respositories.userRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements userService {
	
	private final userRepo u_repo;

	@Override
	public userDTO createUser(userDTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public userDTO getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public userDTO updateUser(userDTO userDto, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public userDTO getUserByID(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<userDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
