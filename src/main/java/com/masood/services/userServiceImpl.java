package com.masood.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.masood.dtos.userDTO;
import com.masood.entities.Provider;
import com.masood.entities.User;
import com.masood.respositories.userRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements userService {

	private final userRepo u_repo;
	private final ModelMapper modelMapper;

	@Override
	public userDTO createUser(userDTO userDto) {
		// Manditory Field checks
		if (userDto.getEmail().isBlank() || userDto.getEmail() == null) {
			throw new IllegalArgumentException("Manditory field Email is missing");
		}

		// user already present
		if (u_repo.existsByEmail(userDto.getEmail())) {
			throw new IllegalArgumentException("User with same email already present");
		}

		User user = modelMapper.map(userDto, User.class);
		user.setProvider(userDto.getProvider() != null ? userDto.getProvider() : Provider.LOCAL);
		
		// Assigning the role for the new users when created.
		//TODO:
		
		User savedUser = u_repo.save(user);
		return modelMapper.map(savedUser, userDTO.class);
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
		return u_repo.findAll().stream().map(u -> modelMapper.map(u, userDTO.class)).toList();
	}

}
