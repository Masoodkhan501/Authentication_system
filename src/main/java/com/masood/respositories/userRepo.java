package com.masood.respositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masood.entities.User;

public interface userRepo extends JpaRepository<User, UUID>{

}
