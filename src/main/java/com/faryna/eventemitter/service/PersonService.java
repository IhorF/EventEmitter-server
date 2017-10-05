package com.faryna.eventemitter.service;

import com.faryna.eventemitter.domain.Person;
import com.faryna.eventemitter.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public Person getPersonById (Integer id){
        return personRepository.getPersonById(id);
    }
}
