package com.masood.dtos.user;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UpdateUserDTO {
	@NotBlank(message = "User ID while updating shouldn't be null")
    private UUID id;
    private String name;
    private String email;
    private String image;
    private boolean enabled;
}
