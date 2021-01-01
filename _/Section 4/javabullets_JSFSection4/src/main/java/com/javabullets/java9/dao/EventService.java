package com.javabullets.java9.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.javabullets.java9.entity.Entrant;
import com.javabullets.java9.entity.Event;

@Stateless
public class EventService {
	
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Event event) {
        entityManager.persist(event);
    }
    
    public void addEntrant(Event event, Entrant entrant) throws Exception {
       event = findOne(event.getId());
       entrant.setEvent(event);
       event.getEntrantList().add(entrant);		
    }
    
    public void remove(Event event) {
        entityManager.remove(event);
    }
    
    public Event findOne(Long id) throws Exception {
        return entityManager.find(Event.class, id);
    }

    public List<Event> findAll() throws Exception {
        TypedQuery<Event> query = 
        		entityManager.createQuery("SELECT e from Event e", Event.class);
        return query.getResultList();
    }
    
}