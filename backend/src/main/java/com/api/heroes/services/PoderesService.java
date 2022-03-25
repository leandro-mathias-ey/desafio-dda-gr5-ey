package com.api.heroes.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.heroes.models.PoderesModel;
import com.api.heroes.repository.PoderesRepository;




@Service
public class PoderesService {
	
	final PoderesRepository poderesRepository;
	
	public PoderesService(PoderesRepository poderesRepository) {
		this.poderesRepository = poderesRepository;
	}

	
	public Page<PoderesModel> findAll(Pageable pageable) {
        return poderesRepository.findAll(pageable);
    }


}
