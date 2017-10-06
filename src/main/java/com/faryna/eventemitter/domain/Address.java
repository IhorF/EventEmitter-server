package com.faryna.eventemitter.domain;


import com.faryna.eventemitter.DTO.EntityInterface;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Address implements EntityInterface{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_address", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToMany
    @JoinTable(name = "address_has_event", joinColumns = @JoinColumn(name = "address_id_address", referencedColumnName = "id_address", nullable = false), inverseJoinColumns = @JoinColumn(name = "event_id_event", referencedColumnName = "id_event", nullable = false))
    private Set<Event> events;

    public Integer getId() {
        return id;
    }

    public void setId(Integer idAddress) {
        this.id = idAddress;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != null ? !id.equals(address.id) : address.id != null) return false;
        if (name != null ? !name.equals(address.name) : address.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
