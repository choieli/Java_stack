package com.codingdojo.got.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.got.models.House;
import com.codingdojo.got.services.GotService;

@RestController
public class HousesCtrl {
	@Autowired
	private GotService gS;
	
	@GetMapping("/houses")
	public List<House> getAllHouses() {
	return gS.getAllHouses();
	}
	
	@PostMapping("/houses")
	public House createHouse(@RequestParam("name") String name, @RequestParam("sigil") String sigil) {
		return gS.createHouse(name, sigil);

	}

}
