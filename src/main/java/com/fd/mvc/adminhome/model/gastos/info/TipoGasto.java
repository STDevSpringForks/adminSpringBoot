package com.fd.mvc.adminhome.model.gastos.info;

import lombok.Getter;

@Getter
public enum TipoGasto {
	
	AUTOMOVIL("Automovil");
	
	private String value;
	
	TipoGasto(String value){
		this.value = value;
	}


}
