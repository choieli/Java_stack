package com.codingdojo.demo.controllers;

//import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersCtrl {
	@RequestMapping("/")
//	public String homeRoute(Model model) {
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("Cake");
//		list.add("Milk");
//		
//		model.addAttribute("groceryList", list);
	
	public String counter(HttpSession session) {
		Integer counter = (Integer) session.getAttribute("currentCounter");
		
		if(counter == null) {
			session.setAttribute("currentCounter", 1);
		} else {
			counter++;
			session.setAttribute("currentCounter", counter);
		}
		return "index.jsp";
	}
	
//	@RequestMapping("/search")
//	public String queryParamsExample(@RequestParam(value="name") String n) {
//		System.out.println(n);
//		return "";
//	}
}
