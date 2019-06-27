package com.codingdojo.dojos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojos.models.CategoryProduct;

@Repository
public interface CategoryProductRepo extends CrudRepository<CategoryProduct, Long> {

}
