package com.masood.dtos.user;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.masood.dtos.RolesDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserDTO {

	private UUID userId;
	private String name;
	private String imageUrl;
	private String email;
	private Set<RolesDTO> roles = new HashSet<>();
}
