package com.fd.mvc.model.entity;


import jakarta.persistence.*;


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

}
