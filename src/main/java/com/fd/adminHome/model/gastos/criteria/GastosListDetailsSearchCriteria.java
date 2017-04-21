package com.fd.adminHome.model.gastos.criteria;

import java.io.Serializable;

import com.fd.adminHome.model.gastos.info.TipoGasto;

/**
 * 
 * @author Muguruza
 *
 */
public class GastosListDetailsSearchCriteria implements Serializable {

	private static final long serialVersionUID = 5908612392625501425L;
	
	private String descripcion;
	private TipoGasto tipoGasto;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoGasto getTipoGasto() {
		return tipoGasto;
	}
	public void setTipoGasto(TipoGasto tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GastosListDetailsSearchCriteria [descripcion=");
		builder.append(descripcion);
		builder.append(", tipoGasto=");
		builder.append(tipoGasto);
		builder.append("]");
		return builder.toString();
	}
	
	
}
