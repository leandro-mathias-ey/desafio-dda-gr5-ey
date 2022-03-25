package com.api.heroes.dtos;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class HeroesDto {

	@NotBlank
	private String nomeHeroi;
	private UUID universoId;
	private UUID usuarioId;
	
	

	public UUID getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(UUID usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNomeHeroi() {
		return nomeHeroi;
	}

	public void setNomeHeroi(String nomeHeroi) {
		this.nomeHeroi = nomeHeroi;
	}

	public UUID getUniversoId() {
		return universoId;
	}

	public void setUniversoId(UUID universoId) {
		this.universoId = universoId;
	}
	
	
	
	
}
