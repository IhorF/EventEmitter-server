package com.faryna.eventemitter.service;

import com.faryna.eventemitter.domain.Event;
import com.faryna.eventemitter.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event getEventById (Integer id){ return eventRepository.findOne(id);}

    public  void  addEvent (Event event) { eventRepository.save(event);}
}


