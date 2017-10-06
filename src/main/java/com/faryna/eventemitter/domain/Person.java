package com.faryna.eventemitter.domain;

import com.faryna.eventemitter.DTO.EntityInterface;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person implements EntityInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "surname", nullable = false, length = 45)
    private String surname;

    @Column(name = "telephon", nullable = false, length = 45)
    private String telephon;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "events_persons", joinColumns = {
            @JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")})
    private Set<Event> events;

    public Person() {
    }

    public Person(String name, String surname, String telephon) {
        this.name = name;
        this.surname = surname;
        this.telephon = telephon;

    }

    public Person(Integer id, String name, String surname, String telephon) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telephon = telephon;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idPerson) {
        this.id = idPerson;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephon() {
        return telephon;
    }

    public void setTelephon(String telephon) {
        this.telephon = telephon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (surname != null ? !surname.equals(person.surname) : person.surname != null) return false;
        if (telephon != null ? !telephon.equals(person.telephon) : person.telephon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (telephon != null ? telephon.hashCode() : 0);
        return result;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephon='" + telephon + '\'' +
                ", events=" + events +
                '}';
    }
}
