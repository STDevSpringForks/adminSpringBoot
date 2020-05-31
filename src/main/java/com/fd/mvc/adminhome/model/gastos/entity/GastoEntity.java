package com.fd.mvc.adminhome.model.gastos.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "gastosdetails")
public class GastoEntity implements Serializable {

	private static final long serialVersionUID = 6942507280982369287L;

	@Id
	@Column(name = "rid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rid;
	private String tipoGasto;
	private BigDecimal monto;
	private String descripcion;
	private String pathComprobante;
	private byte[] byteComprobante;

}
