package com.api.heroes.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.heroes.models.UniversosModel;
import com.api.heroes.repository.UniversosRepository;




@Service
public class UniversosService {
	
	final UniversosRepository universosRepository;
	
	public UniversosService(UniversosRepository universosRepository) {
		this.universosRepository = universosRepository;
	}

	
	public Page<UniversosModel> findAll(Pageable pageable) {
        return universosRepository.findAll(pageable);
    }


}
