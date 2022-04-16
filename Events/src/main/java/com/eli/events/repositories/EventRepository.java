package com.eli.events.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eli.events.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

	List<Event> findByState(String state);

	List<Event> findByStateIsNot(String state);

	Event findEventById(Long event_id);
	
	
	
	
	

}
