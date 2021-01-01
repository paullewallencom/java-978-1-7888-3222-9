package com.javabullets.java9.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.javabullets.java9.entity.Entrant;
import com.javabullets.java9.entity.Event;

@Named
@SessionScoped
public class EventBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Event event;

    private Entrant entrant;

    public void reset() {
        event = new Event();
        entrant = new Entrant();
    }

    public Entrant getEntrant() {
        return entrant;
    }

    public void setEntrant(Entrant entrant) {
        this.entrant = entrant;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
}
