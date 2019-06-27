package com.codingdojo.got.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.got.models.House;
import com.codingdojo.got.repositories.HouseRepo;

@Service
public class GotService {
	@Autowired
	private HouseRepo hR;
	
	public List<House> getAllHouses() {
		return hR.findAll();
	}

	public House createHouse(String name, String sigil) {
		House h = new House();
		h.setName(name);
		h.setSigil(sigil);
		
		return hR.save(h);
		
	}
	
}
