package com.eli.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eli.dojosandninjas.models.Dojo;
import com.eli.dojosandninjas.models.Ninja;
import com.eli.dojosandninjas.repositories.DojoRepo;
import com.eli.dojosandninjas.repositories.NinjaRepo;

@Service
public class DojoNinjaServ {
	private final DojoRepo dojoRepo;
	private final NinjaRepo ninjaRepo;
	
	public DojoNinjaServ(DojoRepo dojoRepo, NinjaRepo ninjaRepo) {
		
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	

	public void addDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}

	public List<Dojo> getAllDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo singleDojo(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}
		else {
			return null;
		}
	}
	
	
}
