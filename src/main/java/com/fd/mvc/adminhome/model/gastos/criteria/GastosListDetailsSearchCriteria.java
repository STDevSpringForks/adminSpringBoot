package com.fd.mvc.adminhome.model.gastos.criteria;

import com.fd.mvc.adminhome.model.gastos.info.TipoGasto;
import lombok.Data;

import java.io.Serializable;

@Data
public class GastosListDetailsSearchCriteria implements Serializable {

	private static final long serialVersionUID = 5908612392625501425L;
	
	private String descripcion;
	private TipoGasto tipoGasto;

}
