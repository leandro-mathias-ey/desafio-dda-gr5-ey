package com.api.heroes.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.heroes.models.HeroesModel;

@Repository
public interface HeroesRepository extends JpaRepository<HeroesModel, UUID>{
	
//	boolean existsByHeroesName(String heroesName);

}
