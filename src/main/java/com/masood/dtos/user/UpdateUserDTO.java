package com.masood.dtos.user;

import java.util.UUID;

import com.masood.entities.Provider;

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
    
    // This section is handled seprately using another dto.
    private boolean enabled;
    private Provider provider;
    
    // this section too should be handled seprately using another dto
    private String password;
}
