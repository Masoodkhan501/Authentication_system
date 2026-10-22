package com.masood.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masood.dtos.user.CreateUserDTO;
import com.masood.dtos.user.ResponseUserDTO;
import com.masood.dtos.user.UpdateUserDTO;
import com.masood.services.userService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class userController {
	
	private final userService user_service;
	
	@PostMapping
	public ResponseEntity<ResponseUserDTO> createUser(@Valid @RequestBody CreateUserDTO userDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(user_service.createUser(userDto));
		
	}
	
	@GetMapping
	public ResponseEntity<Iterable<ResponseUserDTO>> getAllUsers(){
		return ResponseEntity.ok(user_service.getAllUsers());
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<ResponseUserDTO> getByEmail(@PathVariable String email){
		return ResponseEntity.ok(user_service.getUserByEmail(email));
	}
	
	@PatchMapping("/me/update/{userId}")
	public ResponseEntity<ResponseUserDTO> updateUser(@RequestBody UpdateUserDTO userdto, @PathVariable("userId") String userId){
		return ResponseEntity.ok(user_service.updateUser(userdto, userId));
	}
	
	@DeleteMapping("/delete/{userId}")
	public void deleteUser(@PathVariable("userId") String userId) {
		user_service.deleteUser(userId);
	}
	
}
