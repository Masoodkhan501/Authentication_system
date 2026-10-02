package com.masood.dtos;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.masood.entities.Provider;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userDTO {
	private UUID id;
	@Email(message = "Email should be in valid pattern")
	@NotBlank(message="Email cannot be empty, null or blank")
	private String email;
	@NotBlank(message = "Name cannot be empty, null or blank")
	@Size(min = 2, max = 50, message = "Name should be within the defined size that is 2 - 50 charector length")
	private String name;
	@NotBlank(message="password can't be empty, null or blank")
	private String password;
	private String image;
	private Instant createdAt = Instant.now();
	private Instant updatedAt = Instant.now();
	private boolean enabled = false;
	private Provider provider = Provider.LOCAL;
	private Set<RoleDTO> roles = new HashSet<>();
}
