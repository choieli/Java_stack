package com.codingdojo.dojos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojos.models.CategoryProduct;
import com.codingdojo.dojos.models.Product;
import com.codingdojo.dojos.services.AppService;

@Controller
public class ProductsCtrl {
	
	@Autowired
	private AppService aS;
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("productObj") Product product) {
		
		return "/products/new.jsp";
	}
	
	@PostMapping("/products")
	public String createProduct(@Valid @ModelAttribute("productObj") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/new.jsp";
		} else {
			Product createdProduct = aS.createProduct(product);
			return "redirect:/products/new" + createdProduct.getId();
		}
	}
	
	@GetMapping("/products/{id}")
	public String showProduct (@PathVariable("id") Long id, Model model, @ModelAttribute("middleTableObj") CategoryProduct cp) {
		Product p = aS.getProductById(id);
		model.addAttribute("product", p);
		model.addAttribute("nonCategories", aS.nonCategories (p));
		return "/products/show.jsp";
	}
	
	@PostMapping("/addCategory")
	public String addCategoryToProduct(@ModelAttribute("middleTableObj") CategoryProduct cp) {
		aS.addCategoryToProduct(cp);
		return "redirect:/products/" + cp.getProduct().getId();
	}
}
