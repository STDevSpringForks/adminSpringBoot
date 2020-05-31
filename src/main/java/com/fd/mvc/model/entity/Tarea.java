package com.fd.mvc.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
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

}
