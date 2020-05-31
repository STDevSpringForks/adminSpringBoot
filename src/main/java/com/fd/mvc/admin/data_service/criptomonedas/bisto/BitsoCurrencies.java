package com.fd.mvc.admin.data_service.criptomonedas.bisto;

/**
 * 
 * @author Muguruza
 *
 */
public enum BitsoCurrencies {
	
	btc_mxn("btc_mxn"),
	eth_mxn("eth_mxn"),
	xrp_mxn("xrp_mxn");
	
	private String currency;
	
	BitsoCurrencies(String currency){
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}
	
}
