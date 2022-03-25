package com.api.heroes.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.heroes.models.PoderesModel;


@Repository
public interface PoderesRepository extends JpaRepository<PoderesModel, UUID>{
	

}
