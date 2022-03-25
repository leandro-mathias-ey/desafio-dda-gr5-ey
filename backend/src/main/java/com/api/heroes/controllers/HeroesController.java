package com.api.heroes.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.heroes.dtos.HeroesDto;
import com.api.heroes.models.HeroesModel;
import com.api.heroes.services.HeroesService;




@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
//@RequestMapping("/heroes")
public class HeroesController {
	
	final HeroesService heroesService;
	
	public HeroesController(HeroesService heroesService) {
		this.heroesService = heroesService;
	}
	
	
	@PostMapping("/heroes/create")
	public ResponseEntity<Object> saveHeroes(@RequestBody @Valid HeroesDto heroesDto){
		
//		if(heroesService.existsByHeroesName(heroesDto.getHeroesName())) {
//			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name is already in use!");
//		}
		
		HeroesModel heroesModel = new HeroesModel();
		BeanUtils.copyProperties(heroesDto, heroesModel);
		heroesModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(heroesService.save(heroesModel));
	}
	
	@GetMapping("/heroes")
	public ResponseEntity<Page<HeroesModel>> getAllHeroes(@PageableDefault(page = 0, size = 10, sort = "heroiId", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(heroesService.findAll(pageable));
	}
	
	@GetMapping("heroes/{heroiId}")
	public ResponseEntity<Object> getOneHero(@PathVariable(value = "heroiId") UUID heroiId){
		Optional<HeroesModel> heroesModelOptional = heroesService.findById(heroiId);
		if(!heroesModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hero not found.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(heroesModelOptional.get());
	}
	
	@DeleteMapping("heroes/delete/{heroiId}")
	public ResponseEntity<Object> deleteHero(@PathVariable(value = "heroiId") UUID heroiId){
		Optional<HeroesModel> heroesModelOptional = heroesService.findById(heroiId);
		if(!heroesModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hero not found.");
		}
		heroesService.delete(heroesModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Hero deleted sucessfully.");
	}
	
	@PutMapping("heroes/update/{heroiId}")
	public ResponseEntity<Object> updateHero(@PathVariable(value = "heroiId") UUID heroiId, 
												@RequestBody @Valid HeroesDto heroesDto){
		Optional<HeroesModel> heroesModelOptional = heroesService.findById(heroiId);
		if(!heroesModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hero not found.");
		}
		
		HeroesModel heroesModel = new HeroesModel();
		BeanUtils.copyProperties(heroesDto, heroesModel);
		heroesModel.setHeroiId(heroesModelOptional.get().getHeroiId());
		heroesModel.setCreatedAt(heroesModelOptional.get().getCreatedAt());
		
		
		return ResponseEntity.status(HttpStatus.OK).body(heroesService.save(heroesModel));
	}
	
}
