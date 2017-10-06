package com.faryna.eventemitter.repository;

import com.faryna.eventemitter.domain.Event;
import com.faryna.eventemitter.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    Event getEventById(Integer id);

    void deleteById(Integer id);

}
