package com.masood.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masood.dtos.userDTO;
import com.masood.services.userService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class userController {
	
	private final userService user_service;
	
	@PostMapping
	public ResponseEntity<userDTO> createUser(@RequestBody userDTO userDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(user_service.createUser(userDto));
		
	}

}
