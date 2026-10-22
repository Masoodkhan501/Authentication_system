package com.masood.services;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.masood.dtos.user.CreateUserDTO;
import com.masood.dtos.user.ResponseUserDTO;
import com.masood.dtos.user.UpdateUserDTO;
import com.masood.entities.Provider;
import com.masood.entities.User;
import com.masood.exceptions.DuplicateRecordException;
import com.masood.exceptions.ResourceNotFound;
import com.masood.helper.userHelper;
import com.masood.respositories.userRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements userService {

	private final userRepo u_repo;
	private final ModelMapper modelMapper;

	@Override
	@Transactional
	public ResponseUserDTO createUser(CreateUserDTO userDto) {

		// user already present
		if (u_repo.existsByEmail(userDto.getEmail())) {
			throw new DuplicateRecordException("User with same email already present");
		}

		User user = modelMapper.map(userDto, User.class);
		user.setProvider(userDto.getProvider() != null ? userDto.getProvider() : Provider.LOCAL);
		
		// Assigning the role for the new users when created.
		//TODO:
		
		User savedUser = u_repo.save(user);
		return modelMapper.map(savedUser, ResponseUserDTO.class);
	}

	@Override
	@Transactional
	public ResponseUserDTO getUserByEmail(String email) {
		User user = u_repo.findByEmail(email)
				.orElseThrow(() ->new ResourceNotFound("User with "+ email +" not found"));
		return modelMapper.map(user,ResponseUserDTO.class);
	}

	@Override
	public ResponseUserDTO updateUser(UpdateUserDTO userDto, String userId) {
		// TODO Auto-generated method stub
		UUID uuid = userHelper.parseUUID(userId);
		
		//verifying whether the user already exists or not
		User user = u_repo
				.findById(uuid)
				.orElseThrow(() -> 
				new ResourceNotFound("User with id : "+userId+" not found"));
		
		
		// This whole section needed to be changed after if you want
		//updating user email address
		if(userDto.getEmail() != null) {
			//need to perform some sort of operation in here.
			user.setEmail(userDto.getEmail());
		}
		
		if(userDto.getName() != null) {
			user.setName(userDto.getName());
		}
		
		if(userDto.getImage() != null) {
			user.setImage(userDto.getImage());
		}
		
		if(userDto.getProvider() != null) {
			user.setProvider(userDto.getProvider());
		}
		
		if(userDto.getPassword() != null) {
			user.setPassword(userDto.getPassword());
		}
		
		// This need to be changed i mean it should be handled seperately right. using seprate Dto
		if(userDto.isEnabled() != false) {
			user.setEnabled(userDto.isEnabled());
		}
		
		// This is the ending of the session we wanted to change it later
		
		
		User updatedUser = u_repo.save(user);
		
		return modelMapper.map(updatedUser, ResponseUserDTO.class);
	}

	@Override
	@Transactional
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
		UUID id = userHelper.parseUUID(userId);
		
		User user = u_repo.findById(id).orElseThrow(() -> new ResourceNotFound("User with id : "+userId+" not found"));
		
		u_repo.delete(user);

	}

	@Override
	public CreateUserDTO getUserByID(String userId) {
		
		User user = u_repo.findById(userHelper.parseUUID(userId))
				.orElseThrow(() -> 
				new ResourceNotFound("User with id : "+userId+" not found"));
		return modelMapper.map(user, CreateUserDTO.class);
	}

	@Override
	@Transactional
	public Iterable<ResponseUserDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return u_repo.findAll().stream().map(u -> modelMapper.map(u, ResponseUserDTO.class)).toList();
	}

}
