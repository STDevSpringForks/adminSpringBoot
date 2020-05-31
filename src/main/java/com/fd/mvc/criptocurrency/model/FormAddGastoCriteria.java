package com.fd.mvc.criptocurrency.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Criteria para añadir un gasto.
 * @author Muguruza
 *
 */
public class FormAddGastoCriteria implements Serializable {

	private static final long serialVersionUID = -4109220386832123084L;
	
	private String tipoGasto;
	private String monto;
	private String descripcion;
	private transient MultipartFile fileComprobante;
	
	public String getTipoGasto() {
		return tipoGasto;
	}
	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public MultipartFile getFileComprobante() {
		return fileComprobante;
	}
	public void setFileComprobante(MultipartFile fileComprobante) {
		this.fileComprobante = fileComprobante;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FormAddGastoCriteria [tipoGasto=");
		builder.append(tipoGasto);
		builder.append(", monto=");
		builder.append(monto);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", fileComprobante=");
		builder.append(fileComprobante);
		builder.append("]");
		return builder.toString();
	}
	
}
