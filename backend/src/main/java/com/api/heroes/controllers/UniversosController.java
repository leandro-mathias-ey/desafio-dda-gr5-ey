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

import com.api.heroes.models.UniversosModel;
import com.api.heroes.services.UniversosService;




@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
//@RequestMapping("/heroes")
public class UniversosController {
	
	final UniversosService universosService;
	
	public UniversosController(UniversosService universosService) {
		this.universosService = universosService;
	}
	
		
	@GetMapping("/heroes/universos")
	public ResponseEntity<Page<UniversosModel>> getAllUniversos(@PageableDefault(page = 0, size = 1500, sort = "universoId", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(universosService.findAll(pageable));
	}
	

	
}
