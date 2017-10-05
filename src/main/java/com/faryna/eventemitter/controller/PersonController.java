package com.faryna.eventemitter.controller;

import com.faryna.eventemitter.DTO.DTOBuilder;
import com.faryna.eventemitter.DTO.impl.PersonDTO;
import com.faryna.eventemitter.domain.Person;
import com.faryna.eventemitter.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/api/person/{personId}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Integer personId) {
        Person person = personService.getPersonById(personId);
        Link selfLink = linkTo(methodOn(PersonController.class).getPersonById(personId)).withSelfRel();
        PersonDTO linkDTO = DTOBuilder.buildDtoForEntity(person, PersonDTO.class, selfLink);
        return new ResponseEntity<>(linkDTO, HttpStatus.OK);
    }

    @PostMapping("/api/person")
    public ResponseEntity<PersonDTO> addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        Link selfLink = linkTo(methodOn(PersonController.class).getPersonById(person.getId())).withSelfRel();
        PersonDTO personDTO = DTOBuilder.buildDtoForEntity(person, PersonDTO.class, selfLink);
        return new ResponseEntity<>(personDTO, HttpStatus.CREATED);
    }
}
