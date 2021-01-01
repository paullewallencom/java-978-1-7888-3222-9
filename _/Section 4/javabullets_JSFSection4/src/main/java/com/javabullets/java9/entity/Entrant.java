package com.javabullets.java9.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ENTRANT")
public class Entrant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ENTRANT_ID", updatable = false, nullable = false)
	private Long id;
	@Column(name = "FORENAME")
	private String forename;
	@Column(name = "SURNAME")
	private String surname;
	@Column(name = "AGE")
	private Integer age;
	
    @Enumerated(EnumType.STRING)
	private Sex sex;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENT_ID")
	private Event event;

	public Entrant() {
	}

	public Entrant(Long id, String forename, String surname, Integer age, Sex sex) {
		this.id = id;
		this.setForename(forename);
		this.setSurname(surname);
		this.setAge(age);
		this.setSex(sex);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
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
		final Entrant other = (Entrant) obj;
		if ((this.getId() == null) ? (other.getId() != null) : !this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

}