package com.codingdojo.dojos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.codingdojo.dojos.models.Ninja;
import com.codingdojo.dojos.services.AppService;

@Controller
public class NinjaCtrl {
	@Autowired
	private AppService aS;
	
	@GetMapping("/ninjas/new")
	public String newNinja(Model model) {
		model.addAttribute("ninjaObj", new Ninja());
		model.addAttribute("allDojos", aS.getAllDojos ());
		return "/ninjas/new.jsp";
	}
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninjaObj") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/ninjas/new.jsp";
		} else {
			aS.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
}
