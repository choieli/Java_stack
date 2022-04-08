package com.eli.queriesjoins.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eli.queriesjoins.models.Language;

@Repository
public interface LanguageRepo extends CrudRepository<Language,Long> {
	
}