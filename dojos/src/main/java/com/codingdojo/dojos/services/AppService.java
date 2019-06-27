package com.codingdojo.dojos.services;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojos.models.Category;
import com.codingdojo.dojos.models.CategoryProduct;
import com.codingdojo.dojos.models.Dojo;
import com.codingdojo.dojos.models.Ninja;
import com.codingdojo.dojos.models.Product;
import com.codingdojo.dojos.repositories.CategoryProductRepo;
import com.codingdojo.dojos.repositories.CategoryRepo;
import com.codingdojo.dojos.repositories.DojoRepo;
import com.codingdojo.dojos.repositories.NinjaRepo;
import com.codingdojo.dojos.repositories.ProductRepo;

@Service
public class AppService {
	@Autowired
	private DojoRepo dR;
	@Autowired
	private NinjaRepo nR;
	@Autowired
	private ProductRepo pR;
	@Autowired
	private CategoryRepo cR;
	@Autowired
	private CategoryProductRepo cpR;

	public void createDojo(Dojo dojo) {
		dR.save(dojo);
		
	}

	public List<Dojo> getAllDojos() {
		
		return dR.findAll();
	}

	public List<Category> getAllCategories() {
		
		return cR.findAll();
	}
	
	public void createNinja(Ninja ninja) {
		nR.save(ninja);
		
	}

	public Product createProduct(Product product) {
		return pR.save(product);
		
	}

	public Product getProductById(Long id) {
		Optional<Product> optionalProduct = pR.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
	
	public List<Category> nonCategories(Product p){
		List<Category> currentCats = p.getCategories();
		List<String> currentCatsNames = new ArrayList<String>();
		if (currentCats.size() == 0) {
			currentCatsNames.add("");
		} else {
			for(Category cat : currentCats) {
				currentCatsNames.add(cat.getName());
			}
		}
		return cR.findByNameNotIn(currentCatsNames);
	}

	public void addCategoryToProduct(CategoryProduct cp) {
		cpR.save(cp);
	}

}
