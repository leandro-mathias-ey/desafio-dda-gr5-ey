package com.api.heroes.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Table(name = "herois")
@SQLDelete(sql = "UPDATE herois SET deleted = true WHERE heroi_id=?")
@Where(clause = "deleted IS null")

public class HeroesModel implements Serializable {
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID heroiId;
	@Column(nullable = false, unique = false)
	private String nomeHeroi;
	@Column(nullable = false)
	private LocalDateTime createdAt;
	@Column()
	private Boolean deleted;
	@Column()
	private UUID universoId;
	@Column()
	private UUID usuarioId;

//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "universoId", referencedColumnName = "universoId")
//    private UniversosModel universoId;
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "usuarioId", referencedColumnName = "usuarioId")
//    private UserModel usuarioId;
	
	

	public UUID getHeroiId() {
		return heroiId;
	}

	public void setHeroiId(UUID heroiId) {
		this.heroiId = heroiId;
	}

	public String getNomeHeroi() {
		return nomeHeroi;
	}

	public void setNomeHeroi(String nomeHeroi) {
		this.nomeHeroi = nomeHeroi;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getDeleted_at() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted= deleted;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UUID getUniversoId() {
		return universoId;
	}

	public void setUniversoId(UUID universoId) {
		this.universoId = universoId;
	}

	public UUID getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(UUID usuarioId) {
		this.usuarioId = usuarioId;
	}
}
