package com.faryna.eventemitter.domain;

import com.faryna.eventemitter.DTO.EntityInterface;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Event implements EntityInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_event", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Basic
    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @Basic
    @Column(name = "date")
    private Date date;

    @ManyToMany(mappedBy = "events")
    private Set<Address> adresses;

    @ManyToMany(mappedBy = "events")
    private Set<Person> persons;

    public Event() {
    }

    public Event(String name, String description, Date date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Event(Integer id, String name, String description, Date date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idEvent) {
        this.id = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (date != null ? !date.equals(event.date) : event.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }


    public Set<Address> getAdresses() {
        return adresses;
    }

    public void setAdresses(Set<Address> adresses) {
        this.adresses = adresses;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
