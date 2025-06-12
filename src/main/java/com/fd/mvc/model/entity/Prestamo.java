package com.fd.mvc.model.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

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
	
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
