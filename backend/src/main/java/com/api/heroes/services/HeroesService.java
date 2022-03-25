package com.api.heroes.services;

import java.util.UUID;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.heroes.models.HeroesModel;
import com.api.heroes.repository.HeroesRepository;




@Service
public class HeroesService {
	
	final HeroesRepository heroesRepository;
	
	public HeroesService(HeroesRepository heroesRepository) {
		this.heroesRepository = heroesRepository;
	}

	@Transactional
	public HeroesModel save(HeroesModel heroesModel) {
		return  heroesRepository.save(heroesModel);
	}

//	public boolean existsByHeroesName(String heroesName) {
//		return heroesRepository.existsByHeroesName(heroesName);
//	}
	
	public Page<HeroesModel> findAll(Pageable pageable) {
        return heroesRepository.findAll(pageable);
    }


	public Optional<HeroesModel> findById(UUID heroiId) {
		return heroesRepository.findById(heroiId);
	}

	@Transactional
	public void delete(HeroesModel heroesModel) {
		heroesRepository.delete(heroesModel);
		
	}
	
	//SoftDelete
//	public Iterable<HeroesModel> findAll(boolean isDeleted){
//		return heroesRepository.findAll();
//	}
}
