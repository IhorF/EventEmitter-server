package com.faryna.eventemitter.controller;

import com.faryna.eventemitter.DTO.DTOBuilder;
import com.faryna.eventemitter.DTO.impl.EventDTO;
import com.faryna.eventemitter.DTO.impl.PersonDTO;
import com.faryna.eventemitter.domain.Event;
import com.faryna.eventemitter.domain.Person;
import com.faryna.eventemitter.service.EventService;
import com.faryna.eventemitter.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;
    @Autowired
    private EventService eventService;

    @GetMapping(value = "/api/person/{personId}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Integer personId) {
        Person person = personService.getPersonById(personId);
        Link selfLink = linkTo(methodOn(PersonController.class).getPersonById(personId)).withSelfRel();
        PersonDTO linkDTO = DTOBuilder.buildDtoForEntity(person, PersonDTO.class, selfLink);
        return new ResponseEntity<>(linkDTO, HttpStatus.OK);
    }

    @PostMapping("/api/events/{eventId}")
    public ResponseEntity<PersonDTO> addPersonToEvent(@RequestBody Person person, @PathVariable Integer eventId) {
        System.out.println(eventId);
        LOGGER.debug("Added new Person with name: {} surname {} ", person.getName(), person.getSurname());
        personService.addPerson(person, eventId);
        Link selfLink = linkTo(methodOn(PersonController.class).getPersonById(person.getId())).withSelfRel();
        PersonDTO personDTO = DTOBuilder.buildDtoForEntity(person, PersonDTO.class, selfLink);
        return new ResponseEntity<>(personDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/events/{eventId}/persons")
    public ResponseEntity<List<PersonDTO>> getAllPersonByEvent(@PathVariable Integer eventId) {
        List<Person> personList = personService.findAllPersonsByEvents(eventId);
        Link collectionLink = linkTo(methodOn(EventController.class).getAllEvents()).withRel("event");
        List<PersonDTO> persons = DTOBuilder.buildDtoListForCollection(personList,
                PersonDTO.class, collectionLink);
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
