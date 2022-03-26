package com.api.heroes.dtos;

import com.api.heroes.models.UniversosModel;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class HeroesDto {

	@NotBlank
	private String nomeHeroi;
	private UniversosModel universo;
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

	public UniversosModel getUniverso() {
		return universo;
	}

	public void setUniverso(UniversosModel universo) {
		this.universo = universo;
	}
}
