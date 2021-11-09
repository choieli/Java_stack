package com.eli.ninjagold;


import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private int gold = 0;
	private Random r = new Random();
	private ArrayList<ArrayList<String>> commentList = new ArrayList<ArrayList<String>>();
	
	
	@RequestMapping("/gold")
	public String index (Model model) {
		model.addAttribute("gold", gold);
		model.addAttribute("logs", commentList);
		return "index.jsp";
	}
	
	@RequestMapping("/farm")
	public String farm() {
		int newGold = r.nextInt(11) + 10;
		Date date = new Date();
		ArrayList<String> actionDetails = new ArrayList<String>();
		actionDetails.add(String.format("You entered a farm and earned %o gold. (%tb %<te %<tY %<tI:%<tM %<Tp)", newGold, date));
		actionDetails.add("green");
		gold += newGold;
		
		commentList.add(actionDetails);
		return "redirect:/gold";
	}
	
	@RequestMapping("/cave")
	public String cave() {
		int newGold = r.nextInt(6) + 5;
		Date date = new Date();
		ArrayList<String> actionDetails = new ArrayList<String>();
		actionDetails.add(String.format("You entered a cave and earned %o gold. (%tb %<te %<tY %<tI:%<tM %<Tp)", newGold, date));
		actionDetails.add("green");
		gold += newGold;
		
		commentList.add(actionDetails);
		return "redirect:/gold";
	}
	
	@RequestMapping("/house")
	public String house() {
		int newGold = r.nextInt(4) + 2;
		Date date = new Date();
		ArrayList<String> actionDetails = new ArrayList<String>();
		actionDetails.add(String.format("You entered a house and earned %s gold. (%tb %<te %<tY %<tI:%<tM %<Tp)", newGold, date));
		actionDetails.add("green");
		gold += newGold;
		
		commentList.add(actionDetails);
		return "redirect:/gold";
	}
	
	@RequestMapping("/casino")
	public String casino() {
		int newGold = r.nextInt(101) - 50;
		Date date = new Date();
		ArrayList<String> actionDetails = new ArrayList<String>();
		
		if (newGold > 0) {
			actionDetails.add(String.format("You entered a casino and earned %s gold. (%tb %<te %<tY %<tI:%<tM %<Tp)", newGold, date));
			actionDetails.add("green");
		}
		else if (newGold < 0) {
			actionDetails.add(String.format("You entered a casino and lost %s gold. (%tb %<te %<tY %<tI:%<tM %<Tp)", newGold, date));
			actionDetails.add("red");
		}
		else {
			actionDetails.add(String.format("You entered a casino and lost %s gold. (%tb %<te %<tY %<tI:%<tM %<Tp)", newGold, date));
			actionDetails.add("black");
		}
		gold += newGold;
		
		commentList.add(actionDetails);
		return "redirect:/gold";
	}
	
	@RequestMapping("/spa")
	public String spa() {
		int newGold = r.nextInt(16) - 20;
		Date date = new Date();
		ArrayList<String> actionDetails = new ArrayList<String>();
		actionDetails.add(String.format("You entered a spa and lost %s gold. (%tb %<te %<tY %<tI:%<tM %<Tp)", newGold, date));
		actionDetails.add("red");
		gold += newGold;
		
		commentList.add(actionDetails);
		return "redirect:/gold";
	}
	
	@RequestMapping("/reset")
	public String reset () {
		commentList.clear();
		gold=0;
		return "redirect:/gold";
	}
	
}

