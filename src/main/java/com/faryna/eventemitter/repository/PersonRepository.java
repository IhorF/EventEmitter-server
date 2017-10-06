package com.faryna.eventemitter.repository;

import com.faryna.eventemitter.domain.Event;
import com.faryna.eventemitter.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {


    Person getPersonById(Integer id);

    List<Person> findAllByEventsContaining(Event event);

    void deleteById(Integer id);
}
