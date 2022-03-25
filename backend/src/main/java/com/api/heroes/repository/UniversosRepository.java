package com.api.heroes.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.heroes.models.UniversosModel;

@Repository
public interface UniversosRepository extends JpaRepository<UniversosModel, UUID>{
	

}
