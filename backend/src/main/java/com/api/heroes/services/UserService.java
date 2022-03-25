package com.api.heroes.services;


import java.util.UUID;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.api.heroes.models.UserModel;
import com.api.heroes.repository.UserRepository;




@Service
public class UserService {
	
	final UserRepository userRepository;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Transactional
	public UserModel save(UserModel userModel) {
		String encodePassword = this.passwordEncoder.encode(userModel.getSenha());
		userModel.setSenha(encodePassword);
		userModel.setEnabled(1);
		return  userRepository.save(userModel);
	}


	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}
	
	public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


	public Optional<UserModel> findById(UUID usuarioId) {
		return userRepository.findById(usuarioId);
	}

	@Transactional
	public void delete(UserModel userModel) {
		userRepository.delete(userModel);
		
	}




}
