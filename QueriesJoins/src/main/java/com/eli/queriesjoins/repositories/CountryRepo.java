package com.eli.queriesjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eli.queriesjoins.models.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country,Long>{
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = ?1 ORDER BY l.percentage desc")
	List<Object[]> countrySpeaksLanguageByPercentage(String language);
	
}

