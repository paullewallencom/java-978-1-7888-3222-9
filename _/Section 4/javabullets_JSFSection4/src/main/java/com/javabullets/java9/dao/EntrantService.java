package com.javabullets.java9.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.javabullets.java9.entity.Entrant;

@Stateless
public class EntrantService {

    @PersistenceContext
	private EntityManager entityManager;

	public void save(Entrant entrant) {
		entityManager.persist(entrant);
	}

	public void remove(Entrant Entrant) {
		entityManager.remove(Entrant);
	}

	public Entrant findOne(Long id) throws Exception {
		return entityManager.find(Entrant.class, id);
	}

	public List<Entrant> findAll() throws Exception {
		TypedQuery<Entrant> query = 
				entityManager.createQuery("SELECT e from Entrant e", Entrant.class);
		return query.getResultList();
	}

}