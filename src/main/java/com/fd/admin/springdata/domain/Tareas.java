package com.fd.admin.springdata.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Muguruza
 *
 */
@Entity
@Table(name = "tareas")
public class Tareas {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTareas;
	
	private String tarea;
	
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

	
}
