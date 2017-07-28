package com.fd.admin.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Muguruza
 *
 */
@Entity
@Table(name = "tareas")
public class Tarea {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTareas;
	
	private String tarea;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person personId;
	
	public Tarea() {
	}
	
	public Tarea(String tarea) {
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
		builder.append("Tarea [idTareas=");
		builder.append(idTareas);
		builder.append(", tarea=");
		builder.append(tarea);
		builder.append(", personId=");
		builder.append(personId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
