package com.faryna.eventemitter.service;

import com.faryna.eventemitter.domain.Event;
import com.faryna.eventemitter.domain.Person;
import com.faryna.eventemitter.repository.EventRepository;
import com.faryna.eventemitter.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EventRepository eventRepository;

    @Transactional
    public void addPerson(Person person, Integer eventId) {
        Event event=eventRepository.getEventById(eventId);
        personRepository.save(person);
        event.getPersons().add(person);
    }

    public Person getPersonById (Integer id){
        return personRepository.getPersonById(id);
    }

    public List<Person>  findAllPersonsByEvents(Integer id){return personRepository.findAllByEventsContaining(eventRepository.findOne((id)));};


}
