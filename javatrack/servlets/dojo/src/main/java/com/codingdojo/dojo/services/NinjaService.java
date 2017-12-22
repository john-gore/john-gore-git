package com.codingdojo.dojo.services;

import org.springframework.stereotype.Service;

import com.codingdojo.dojo.models.Ninja;
import com.codingdojo.dojo.repositories.NinjaRepository;

@Service
public class NinjaService {
private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
}
