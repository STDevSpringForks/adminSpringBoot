package com.fd.adminHome.model.gastos.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Muguruza
 *
 */
@Entity
@Table(name = "gastosdetails")
public class GastosListDetailsEntity {

	private int rid;
	private String tipoGasto;
	private BigDecimal monto;
	private String pathComprobante;
	private String descripcion;
	
	@Id
	@Column(name = "rid")
	@GeneratedValue()
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getTipoGasto() {
		return tipoGasto;
	}
	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public String getPathComprobante() {
		return pathComprobante;
	}
	public void setPathComprobante(String pathComprobante) {
		this.pathComprobante = pathComprobante;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GastosListDetailsEntity [rid=");
		builder.append(rid);
		builder.append(", tipoGasto=");
		builder.append(tipoGasto);
		builder.append(", total=");
		builder.append(monto);
		builder.append(", pathComprobante=");
		builder.append(pathComprobante);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append("]");
		return builder.toString();
	}
	
	
}
