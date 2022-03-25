package com.api.heroes.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.heroes.models.PoderesModel;
import com.api.heroes.services.PoderesService;





@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
//@RequestMapping("/heroes")
public class PoderesController {
	
	final PoderesService poderesService;
	
	public PoderesController(PoderesService poderesService) {
		this.poderesService = poderesService;
	}
	
		
	@GetMapping("/heroes/poderes")
	public ResponseEntity<Page<PoderesModel>> getAllPoderes(@PageableDefault(page = 0, size = 1500, sort = "poderId", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(poderesService.findAll(pageable));
	}
	

	
}
