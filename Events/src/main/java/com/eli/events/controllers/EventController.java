package com.eli.events.controllers;


import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eli.events.models.Event;
import com.eli.events.models.Message;
import com.eli.events.models.User;
import com.eli.events.services.EventService;
import com.eli.events.services.UserService;


@Controller
public class EventController {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private UserService userService;

	
	private final String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID",
	        "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ",
	        "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV",
	        "WY" };
	
	//----------------------------------------------------------------
	// Events - Get Route
	//----------------------------------------------------------------

    @GetMapping("/events")
    public String events(HttpSession session, Model model, @ModelAttribute("event") Event event) {
    	
    	if(null == session.getAttribute("userId")) {
    		//User is not logged in
    		return "redirect:/";
    	} else {
    		Long userId = (Long) session.getAttribute("userId");
        	User u = eventService.findUserById(userId);
        	model.addAttribute("user", u);
        	String state = u.getState();
        	List<Event> eventsIn = eventService.eventsInState(state);
        	model.addAttribute("eventsIn", eventsIn);
        	List<Event> eventsOut = eventService.eventsOutOfState(state);
        	model.addAttribute("eventsOut", eventsOut);
        	model.addAttribute("states", states);  
        	
        	return "events.jsp";
    	}
    }
    
	//----------------------------------------------------------------
	// Events Create- Post Route
	//----------------------------------------------------------------
    @PostMapping(value="/events/create")
    public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
    	if(result.hasErrors()) {
        	Long userId = (Long) session.getAttribute("userId");
        	User u = eventService.findUserById(userId);
        	model.addAttribute("user", u);
        	String state = u.getState();
        	List<Event> eventsIn = eventService.eventsInState(state);
        	model.addAttribute("eventsIn", eventsIn);
        	List<Event> eventsOut = eventService.eventsOutOfState(state);
        	model.addAttribute("eventsOut", eventsOut);
        	model.addAttribute("states", states); 
    		return "events.jsp";
    	}else {
    		eventService.createEvent(event);
    		return "redirect:/events/";
    	}
    }
    

    //----------------------------------------------------------------
    //Add Attendee to Event - Get Route - Join
    //----------------------------------------------------------------
    
    @GetMapping(value="/events/{event_id}/join")
    public String addAttendee(@PathVariable("event_id")Long event_id, HttpSession session) {
    	
    	if(null == session.getAttribute("userId")) {
    		//User is not logged in
    		return "redirect:/";
    	} else {
    		User attendee = eventService.findUserById((Long) session.getAttribute("userId"));
        	Event attending_event = eventService.findEventById(event_id);
    		List<User> attendees = attending_event.getAttendees();
    		attendees.add(attendee);
    		attending_event.setAttendees(attendees);
    		eventService.updateUser(attendee);
    		return "redirect:/events";
    	}
    	
    }
    

    //----------------------------------------------------------------
    //Remove Attendee from Event - Get Route - Cancel
    //----------------------------------------------------------------
    
    @GetMapping(value="/events/{event_id}/cancel")
    public String removeAttendee(@PathVariable("event_id")Long event_id, HttpSession session, Event event) {
    	Long userId = (Long) session.getAttribute("userId");
    	User attendee = eventService.findUserById(userId);
    	Event attending_event = eventService.findEventById(event_id);
    	Long host = attending_event.getHost().getId();
		List<User> attendees = attending_event.getAttendees();
		if(null == userId) {
			return "redirect:/";
		} else if (host != userId) {
			attendees.remove(attendee);
			attending_event.setAttendees(attendees);
			eventService.updateUser(attendee);
			return "redirect:/events";
		} else {
			return "redirect:/events";
		}
		
    }

  //----------------------------------------------------------------
  //Delete Event - Post Route
  //----------------------------------------------------------------
    
//    @RequestMapping("/events/{event_id}/delete")
//    public String deleteEvent(@PathVariable("event_id") Long event_id) {
//    	Event event = eventService.findEventById(event_id);
//    	for(User user: event.getAttendees()) {
//    		List<Event> myevents = user.getAttending_events();
//    		myevents.remove(event);
//    		user.setAttending_events(myevents);;
//    		eventService.updateUser(user);
//    	}
//    	eventService.deleteEvent(event_id);
//    	return "redirect:/events";
//    }
    
    @RequestMapping("/events/{event_id}/delete")
    public String deleteEvent(@PathVariable("event_id") Long event_id, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	Event event = eventService.findEventById(event_id);
    	Long host = event.getHost().getId();
    	if(null == userId) {
    		return "redirect:/";
    	} else if (host == userId) {
    		for(Message message: event.getMessages()) {
        		if(message.getEvent() == event) {
        			eventService.deleteMessage(message.getId());
        		}
        	}
    		eventService.deleteEvent(event_id);
    		return "redirect:/events";
    	} 
        
        return "redirect:/events";
    	
    }
    
    //----------------------------------------------------------------
    //Edit Event - GET Route
    //----------------------------------------------------------------
    
      @RequestMapping("/events/{event_id}/edit")
      public String editEvent(@PathVariable("event_id") Long event_id, Model model, HttpSession session) {
    	  Long userId = (Long) session.getAttribute("userId");
    	  //String user = "" + userId;
    	  Event event = eventService.findEventById(event_id);
    	  Long host = event.getHost().getId();
    	  //String hosts = "" + host;
    	  //Long varLong=Long.parseLong(hosts);
    	  if(null == userId) {
    		//User is not logged in
    		  return "redirect:/";
    	  } else if(host == userId) {
    		
    		  model.addAttribute("event", event);
    		  model.addAttribute("states", states); 
    		  return "eventsEdit.jsp";
    	  } else {
    		  return "redirect:/events";
    	}
      }
      
      
      //----------------------------------------------------------------
      //Edit Event - Post Route
      //----------------------------------------------------------------
      
      @PostMapping("/events/{id}/update")
      public String updateEvent(Model model, @PathVariable("id")Long id, @Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
    	  User user = userService.findUserById((Long)session.getAttribute("userId"));
    	  if (result.hasErrors()) {
          	  model.addAttribute("states", states); 
              return "eventsEdit.jsp";
          } else {
        	  Event eventEdit = eventService.findEventById(id);
        	  model.addAttribute("event", eventEdit);
        	  model.addAttribute("user", user);
        	  model.addAttribute("states", states); 
        	  event.setHost(user);
        	  event.setAttendees(event.getAttendees());
              eventService.updateEvent(event);
              return "redirect:/events/"+event.getId();
          	}
    	  }
      
      
      //----------------------------------------------------------------
      //Show Event - Get Route
      //----------------------------------------------------------------
      @GetMapping("/events/{event_id}")
      public String showEvent(Model model, @PathVariable("event_id")Long event_id, @Valid @ModelAttribute("messageObj") Message message, BindingResult result,  HttpSession session) {
    	  Long userId = (Long) session.getAttribute("userId");
    	  User user = userService.findUserById(userId);
    	  Event event = eventService.findEventById(event_id);
    	  List<Message> messages = event.getMessages();
    	  Collections.reverse(messages);
    	  model.addAttribute("event", event);
    	  model.addAttribute("user", user);
    	  model.addAttribute("attendees", event.getAttendees());
  		  model.addAttribute("messages", messages);
    	  return "eventsId.jsp";
      }
      
      @PostMapping("/events/addmsg")
  	  public String addMessage(@Valid @ModelAttribute("messageObj") Message message, Model model, HttpSession session) {
    	  Long userId = (Long) session.getAttribute("userId");
    	  Long eventId = (Long) session.getAttribute("eventId");
    	  Event event = eventService.findEventById(eventId);
    	  User user = userService.findUserById(userId);
    	  model.addAttribute("event", event);
    	  model.addAttribute("user", user);
    	  model.addAttribute("states", states); 
    	  eventService.newMessage(message);
    	  return "redirect:/events/"+ message.getEvent().getId();
    	  //return "redirect:/events/";
    	  //return "redirect:/persons/" + license.getPerson().getId();
      }
      

  		
  	
      
}

