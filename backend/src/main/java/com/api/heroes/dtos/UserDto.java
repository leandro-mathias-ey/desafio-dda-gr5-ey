package com.api.heroes.dtos;

import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDto {

	@NotBlank
	private String email;
	private String senha;
	private String username;
	private String nome;
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

	

	
	
	
}
