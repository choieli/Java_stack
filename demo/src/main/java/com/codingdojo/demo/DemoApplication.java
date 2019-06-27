package com.codingdojo.demo;

//import java.util.ArrayList;
//import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	@RequestMapping("/")
//	public String homeRoute() {
//		return "Hello";
//	}
	
//	public ArrayList<HashMap<String, String>> homeRoute(){
//		ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String,String>>();
//		HashMap<String, String> h1 = new HashMap<String, String>();
//		h1.put("id","1");
//		h1.put("firstname", "eli");
//		
//		result.add(h1);
//		
//		return result;
//	}
}
