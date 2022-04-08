package com.eli.queriesjoins.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eli.queriesjoins.services.ApiService;

@Controller
public class QJController {
	private final ApiService ApiService;
	
	
	public QJController(com.eli.queriesjoins.services.ApiService apiService) {
		ApiService = apiService;
	}


	@RequestMapping("/")
	public String index(Model model) {
		List<Object[]> question1 = ApiService.question1("slovene");
		List<Object[]> question2 = ApiService.question1("english");
		model.addAttribute("list",question1);
		model.addAttribute("list2",question2);
	
		return "index.jsp";
	}
}
