package com.codingdojo.got.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.got.models.House;


@Repository
public interface HouseRepo extends CrudRepository<House, Long>{
	List<House> findAll();
}
