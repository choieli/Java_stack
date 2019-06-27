package com.codingdojo.dojos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojos.models.Dojo;
import com.codingdojo.dojos.services.AppService;

@Controller
public class DojoCtrl {
	@Autowired
	private AppService aS;
	
	@GetMapping("/dojos/new")
	public String newDojo(Model model) {
		model.addAttribute("dojoObj", new Dojo());
		return "/dojos/new.jsp";
	}
	
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojoObj") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojos/new.jsp";
		} else {
			aS.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
}
