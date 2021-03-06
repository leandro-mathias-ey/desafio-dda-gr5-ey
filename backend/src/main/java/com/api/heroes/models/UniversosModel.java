package com.api.heroes.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Table(name = "universos")

public class UniversosModel implements Serializable {
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID universoId;
	@Column(nullable = false)
	private String universo;
	@Column(nullable = false)
	private LocalDateTime createdAt;

	public UUID getUniversoId() {
		return universoId;
	}
	public void setUniversoId(UUID universoId) {
		this.universoId = universoId;
	}
	public String getUniverso() {
		return universo;
	}
	public void setUniverso(String universo) {
		this.universo = universo;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
