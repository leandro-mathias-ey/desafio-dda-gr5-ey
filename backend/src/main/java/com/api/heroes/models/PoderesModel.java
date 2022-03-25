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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Table(name = "poderes")

public class PoderesModel implements Serializable {
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID poderId;
	@Column(nullable = false)
	private String poder;
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	
	public UUID getPoderId() {
		return poderId;
	}
	public void setPoderId(UUID poderId) {
		this.poderId = poderId;
	}
	public String getPoder() {
		return poder;
	}
	public void setPoder(String poder) {
		this.poder = poder;
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
