package com.faryna.eventemitter.DTO.impl;

import com.faryna.eventemitter.DTO.DTO;
import com.faryna.eventemitter.domain.Person;
import org.springframework.hateoas.Link;

public class PersonDTO extends DTO<Person> {

    public  PersonDTO(Person person, Link link) {super(person, link);}

    public Integer getPersonId() { return getEntity().getId(); }

    public String getName() {
        return getEntity().getName();
    }

    public String getSurname() { return getEntity().getSurname();}

    public String getTelephon() { return getEntity().getTelephon(); }

}
