package com.api.heroes.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.heroes.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID>{
	
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);



}
