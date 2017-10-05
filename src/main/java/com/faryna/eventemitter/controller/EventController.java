package com.faryna.eventemitter.controller;

import com.faryna.eventemitter.DTO.DTOBuilder;
import com.faryna.eventemitter.DTO.impl.EventDTO;
import com.faryna.eventemitter.domain.Event;
import com.faryna.eventemitter.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class EventController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    @GetMapping(value = "/api/event/{eventId}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Integer eventId) {
        Event event = eventService.getEventById(eventId);
        Link selfLink = linkTo(methodOn(EventController.class).getEventById(eventId)).withSelfRel();
        EventDTO linkDTO = DTOBuilder.buildDtoForEntity(event, EventDTO.class, selfLink);
        return new ResponseEntity<>(linkDTO, HttpStatus.OK);
    }

    @PostMapping("/api/event")
    public ResponseEntity<EventDTO> addEvent(@RequestBody Event event) {
        LOGGER.debug("Added new Event with name: {}", event.getName());
        eventService.addEvent(event);
        Link selfLink = linkTo(methodOn(EventController.class).getEventById(event.getId())).withSelfRel();
        EventDTO eventDTO = DTOBuilder.buildDtoForEntity(event, EventDTO.class, selfLink);
        return new ResponseEntity<>(eventDTO, HttpStatus.CREATED);
    }
}
