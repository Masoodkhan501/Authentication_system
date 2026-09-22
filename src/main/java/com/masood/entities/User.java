package com.masood.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.masood.customAnnotations.Uuidv7;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="users")	
public class User {	
	@Id
	@Uuidv7
	@Column(name="user_id", columnDefinition = "BINARY(16)")
	private UUID id;
	@Column(name="user_email", unique = true, length=100)
	private String email;
	@Column(name="user_name", length = 55)
	private String name;
	
	private String password;
	private String image;
	private boolean enabled;
	private Instant createdAt = Instant.now();
	private Instant updatedAt = Instant.now();
	
	@Enumerated(EnumType.STRING)
	private Provider provider = Provider.LOCAL;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
			 joinColumns = @JoinColumn(name="user_id"),
			 inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@PrePersist
	protected void onCreate() {
		if(createdAt == null) createdAt = Instant.now();
		updatedAt= Instant.now();
	}
	
	@PreUpdate
	protected void onUpdate() {
		updatedAt= Instant.now();
	}
}
