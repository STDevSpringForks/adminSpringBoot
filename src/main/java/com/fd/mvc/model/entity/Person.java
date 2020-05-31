package com.fd.mvc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "person")
public class Person {

	@Id
	@Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	
	//fk_prestamo_person1
	
	public Person() {
	}
	
	public Person(String firstName, String lastName, String gender, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
	}
	
	/* Hacer la tabla person y tramite sea bidireccional entonces... */
	//@OneToOne(mappedBy = "person") /* "person" es igual al nombre de que le da en la variable en la otra clase... en este caso prestamo en @OneToOne */
	//private Prestamo prestamo;
	
	@OneToMany(mappedBy = "personId",cascade = CascadeType.REMOVE)
	private Set<Tarea> tarea;
	

}
