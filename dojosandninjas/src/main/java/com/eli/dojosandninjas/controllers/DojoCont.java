package com.eli.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eli.dojosandninjas.models.Dojo;
import com.eli.dojosandninjas.services.DojoNinjaServ;

@Controller
public class DojoCont {
	private final DojoNinjaServ dojoNinjaServ;
	
	public DojoCont(DojoNinjaServ dojoNinjaServ) {
		this.dojoNinjaServ = dojoNinjaServ;
	}
	
	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("dojo") Dojo dojo) {
		List<Dojo> dojos = dojoNinjaServ.getAllDojos();
		model.addAttribute("dojos",dojos);
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojoObject") Dojo dojo) {
		return "newdojo.jsp";
	}
	
	@PostMapping("/adddojo")
	public String addDojo(@Valid @ModelAttribute("dojoObject") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newdojo.jsp";
		}
		else {
			dojoNinjaServ.addDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/dojos/{dojoId}")
	public String showDojo(@PathVariable("dojoId") long id, Model model) {
		Dojo dojo = dojoNinjaServ.singleDojo(id);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}
}
