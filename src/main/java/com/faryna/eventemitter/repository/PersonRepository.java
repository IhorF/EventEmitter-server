package com.faryna.eventemitter.repository;

import com.faryna.eventemitter.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {


    Person getPersonById(Integer id);

    void deleteById(Integer id);
}
