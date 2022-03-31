package com.eli.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eli.dojosandninjas.models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository <Dojo, Long> {
	List<Dojo> findAll();
}
