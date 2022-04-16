package com.eli.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eli.events.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

}
