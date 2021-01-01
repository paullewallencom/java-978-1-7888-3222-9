package com.javabullets.java9.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private LocalDateTime eventDateTime;
    private String location;
    private String country;

    private List<Entrant> entrantList = new ArrayList<>();

    public Event() {
    }

    public Event(Long id, String name, LocalDateTime eventDateTime, String location, String country) {
        this.id = id;
        this.name = name;
        this.eventDateTime = eventDateTime;
        this.location = location;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entrant> getEntrantList() {
        return entrantList;
    }

    public void setEntrantList(List<Entrant> entrantList) {
        this.entrantList = entrantList;
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if ((this.getId() == null) ? (other.getId() != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
