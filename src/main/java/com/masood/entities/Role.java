package com.masood.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name="role")
@Table(name="roles")
public class Role {
	@Id
	private UUID id = UUID.randomUUID();// id of the roles
	@Column(name="role_name",unique = true, nullable = false)
	private String name;//name of the role eg: admin, guest etc
}
