package com.faryna.eventemitter.DTO.impl;

import com.faryna.eventemitter.DTO.DTO;
import com.faryna.eventemitter.domain.Event;
import org.springframework.hateoas.Link;

import java.sql.Time;
import java.util.Date;

public class EventDTO extends DTO<Event> {

    public  EventDTO(Event event, Link link) {super(event, link);}

    public Integer getEventId(){return  getEntity().getId();}

    public String getName() {
        return getEntity().getName();
    }

    public String getDescription() { return getEntity().getDescription();}

    public Date getDate() { return getEntity().getDate(); }

}
