package com.api.heroes.dtos;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class UniversosDto {

	@NotBlank
	private UUID universoId;

	public UUID getUniversoId() {
		return universoId;
	}

	public void setUniversoId(UUID universoId) {
		this.universoId = universoId;
	}
	

	
	
	
}
