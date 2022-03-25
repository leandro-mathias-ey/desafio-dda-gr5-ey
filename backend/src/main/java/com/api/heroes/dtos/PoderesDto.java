package com.api.heroes.dtos;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class PoderesDto {

	@NotBlank
	private UUID poderId;

	public UUID getPoderId() {
		return poderId;
	}

	public void setPoderId(UUID poderId) {
		this.poderId = poderId;
	}
	

	
	
	
}
