package com.api.heroes.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.api.heroes.dtos.UserDto;
import com.api.heroes.models.UserModel;
import com.api.heroes.services.UserService;




@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
//@RequestMapping("/heroes")
public class UserController {
	
	final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@PostMapping("/user/create")
	public ResponseEntity<Object> saveHeroes(@RequestBody @Valid UserDto userDto){
		
		if(userService.existsByEmail(userDto.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Email is already in use!");
		}
		
		if(userService.existsByUsername(userDto.getUsername())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: UserName is already in use!");
			
		}
		
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(userDto, userModel);
		userModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String senha = passwordEncoder.encode(userModel.getSenha());
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
		
	}
	
	@GetMapping("/user")
	public ResponseEntity<Page<UserModel>> getAllUsers(@PageableDefault(page = 0, size = 10, sort = "usuarioId", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageable));
	}
	
	@GetMapping("/user/{usuarioId}")
	public ResponseEntity<Object> getOneUser(@PathVariable(value = "usuarioId") UUID usuarioId){
		Optional<UserModel> userModelOptional = userService.findById(usuarioId);
		if(!userModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
	}
	
	@DeleteMapping("/user/delete/{usuarioId}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "usuarioId") UUID usuarioId){
		Optional<UserModel> userModelOptional = userService.findById(usuarioId);
		if(!userModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}
		userService.delete(userModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("User deleted sucessfully.");
	}
	
	@PutMapping("/user/update/{usuarioId}")
	public ResponseEntity<Object> updateUser(@PathVariable(value = "usuarioId") UUID usuarioId, 
												@RequestBody @Valid UserDto userDto){
		Optional<UserModel> userModelOptional = userService.findById(usuarioId);
		if(!userModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}
		
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(userDto, userModel);
		userModel.setUsuarioId(userModelOptional.get().getUsuarioId());
		userModel.setCreatedAt(userModelOptional.get().getCreatedAt());
		
		
		return ResponseEntity.status(HttpStatus.OK).body(userService.save(userModel));
	}
	
}
