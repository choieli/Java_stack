package com.eli.queriesjoins.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eli.queriesjoins.models.City;

@Repository
public interface CityRepo extends CrudRepository<City,Long> {

}
