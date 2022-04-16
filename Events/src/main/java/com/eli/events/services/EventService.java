package com.eli.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eli.events.models.Event;
import com.eli.events.models.Message;
import com.eli.events.models.User;
import com.eli.events.models.UserEvent;
import com.eli.events.repositories.EventRepository;
import com.eli.events.repositories.MessageRepository;
import com.eli.events.repositories.UserEventRepository;
import com.eli.events.repositories.UserRepository;

@Service
public class EventService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserEventRepository userEventRepo;
	
	@Autowired
	private EventRepository eventRepo;
	
	@Autowired
	private MessageRepository messageRepo;
	
	
//  ----------------------------------------------------------------
//  find 
//  ----------------------------------------------------------------

	public User findUserById(Long userId) {
    	Optional<User> u = userRepo.findById(userId);
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
	

	

	public List<Event> eventsInState(String state) {
    	return eventRepo.findByState(state);
	}

	public List<Event> eventsOutOfState(String state) {
    	return eventRepo.findByStateIsNot(state);
	}
	
	public Event findEventById(Long event_id) {
		return eventRepo.findEventById(event_id);
	}
	
//  ----------------------------------------------------------------
//  create and delete
//  ----------------------------------------------------------------
	

	public Event createEvent(Event event) {
		return eventRepo.save(event);
		
	}

	public UserEvent createRelationship(UserEvent userEvent) {
		return userEventRepo.save(userEvent);
		
	}

	public void deleteEvent(Long event_id) {
		eventRepo.deleteById(event_id);
	}
	
	public void deleteAllMessages(Long event_id) {
		messageRepo.deleteById(event_id);
	}

	public Event updateEvent(Event event) {
		return this.eventRepo.save(event);
		
	}

	public void updateUser(User attendee) {
		userRepo.save(attendee);
		
	}
	
	public void newMessage(Message message) {
        messageRepo.save(message);
    }
	
	public void deleteMessage(Long message_id) {
		messageRepo.deleteById(message_id);
	}
	


	
	

	
}
