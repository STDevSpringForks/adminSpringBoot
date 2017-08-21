package com.fd.admin.springdata.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Muguruza
 *
 */
@Entity
@Table(name = "person")
public class Persona {

	@Id
	@Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	
	public Persona() {
	}
	
	public Persona(String firstName, String lastName, String gender, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
	}
	
	/**
	 * personId es el nombre del atributoClase de la clase: UrlSocialNetwork.
	 */
	@OneToMany(mappedBy = "persona") /* Nombre del atributo en UrlSocialNetwork */
	private Set<UrlSocialNetwork> urlSocialNetwork;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonListDetailsEntity [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
}