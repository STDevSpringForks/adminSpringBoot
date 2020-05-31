package com.fd.mvc.adminhome.model.gastos.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "gastosdetails")
public class GastoEntity2 {

	@Id
	@Column(name = "rid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rid;
	private String tipoGasto;
	private String descripcion;
	private String pathComprobante;
	
}
