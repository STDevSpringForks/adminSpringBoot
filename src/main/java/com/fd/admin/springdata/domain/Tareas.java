package com.fd.admin.springdata.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fd.admin.model.entity.Person;

/**
 * 
 * @author Muguruza
 * Caused by: java.sql.SQLSyntaxErrorException: Unknown column 'tareas0_.id_tareas' in 'field list'
 *
 *
 */
@Entity
@Table(name = "tareas")
public class Tareas {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idTareas")
	private int idTareas;
	
	private String tarea;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person personId;
	
	public Tareas() {
	}
	
	public Tareas(String tarea) {
		this.tarea = tarea;
	}
	
	public int getIdTareas() {
		return idTareas;
	}

	public void setIdTareas(int idTareas) {
		this.idTareas = idTareas;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public Person getPersonId() {
		return personId;
	}

	public void setPersonId(Person personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tareas [idTareas=");
		builder.append(idTareas);
		builder.append(", tarea=");
		builder.append(tarea);
		builder.append(", personId=");
		builder.append(personId);
		builder.append("]");
		return builder.toString();
	}
	

	
}
