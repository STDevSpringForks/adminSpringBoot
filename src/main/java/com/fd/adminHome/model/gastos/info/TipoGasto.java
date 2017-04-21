package com.fd.adminHome.model.gastos.info;

/**
 * 
 * @author Muguruza
 *
 */
public enum TipoGasto {
	
	AUTOMOVIL("Automovil");
	
	private String value;
	
	private TipoGasto(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
