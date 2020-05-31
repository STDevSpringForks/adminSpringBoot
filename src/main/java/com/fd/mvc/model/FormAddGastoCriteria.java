package com.fd.mvc.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
public class FormAddGastoCriteria implements Serializable {

	private static final long serialVersionUID = -4109220386832123084L;
	
	private String tipoGasto;
	private String monto;
	private String descripcion;
	private transient MultipartFile fileComprobante;
	
}
