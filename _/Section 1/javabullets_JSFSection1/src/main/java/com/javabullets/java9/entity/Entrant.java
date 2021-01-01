package com.javabullets.java9.entity;

import java.io.Serializable;

public class Entrant implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String forename;
	private String surname;
	private Integer age;
	private Sex sex;

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