package com.eli.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eli.events.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmail(String email);

}
