package com.fd.mvc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "prestamo")
public class Prestamo {

	@Id
	@Column(name = "idPrestamo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrestamo;
	
	private String concepto;
	private BigDecimal monto;
	private Date fechaPrestamo;
	
	@OneToOne
	@JoinColumn(name = "person_id") /* Nombre de la columna que hace referencia a la llave foranea */
	private Person person;
	
	public Prestamo() {
	}
	
	public Prestamo(String concepto, BigDecimal monto, Date fechaPrestamo) {
		this.concepto = concepto;
		this.monto = monto;
		this.fechaPrestamo = fechaPrestamo;
	}
	
}
