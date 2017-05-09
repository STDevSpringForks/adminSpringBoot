package com.fd.adminHome.model.gastos.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

import javax.persistence.Column;
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
@Table(name = "gastosdetails")
public class GastoEntity implements Serializable {

	private static final long serialVersionUID = 6942507280982369287L;
	
	private int rid;
	private String tipoGasto;
	private BigDecimal monto;
	private String descripcion;
	private String pathComprobante;
	private byte[] byteComprobante;
	
	@Id
	@Column(name = "rid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPathComprobante() {
		return pathComprobante;
	}
	public void setPathComprobante(String pathComprobante) {
		this.pathComprobante = pathComprobante;
	}
	public byte[] getByteComprobante() {
		return byteComprobante;
	}
	public void setByteComprobante(byte[] byteComprobante) {
		this.byteComprobante = byteComprobante;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GastoEntity [rid=");
		builder.append(rid);
		builder.append(", tipoGasto=");
		builder.append(tipoGasto);
		builder.append(", monto=");
		builder.append(monto);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", pathComprobante=");
		builder.append(pathComprobante);
		builder.append(", byteComprobante=");
		builder.append(Arrays.toString(byteComprobante));
		builder.append("]");
		return builder.toString();
	}
	
}