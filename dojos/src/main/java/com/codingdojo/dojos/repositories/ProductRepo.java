package com.codingdojo.dojos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojos.models.Product;



@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

}
