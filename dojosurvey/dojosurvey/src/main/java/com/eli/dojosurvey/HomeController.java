package com.eli.dojosurvey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(@RequestParam(value="name") String name,
			@RequestParam(value="location") String location,
			@RequestParam(value="language") String lang,
			@RequestParam(value="comment") String comment,
			RedirectAttributes redirectAttributes) {
		if (name.isEmpty()) {
			redirectAttributes.addFlashAttribute("nameError", "Name is required!");
			return "redirect:/";
		}
		redirectAttributes.addFlashAttribute("name", name);
		redirectAttributes.addFlashAttribute("location", location);
		redirectAttributes.addFlashAttribute("lang", lang);
		if (!comment.isEmpty()) {
			redirectAttributes.addFlashAttribute("comment", comment);
		}
		
		return "redirect:/results";
	}
	
	@RequestMapping("/results")
	public String results() {
		return "results.jsp";
	}
}
