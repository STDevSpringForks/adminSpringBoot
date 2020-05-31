package com.fd.mvc.codevalue;

import lombok.Getter;

@Getter
public enum BitsoCurrencies {
	
	btc_mxn("btc_mxn"),
	eth_mxn("eth_mxn"),
	xrp_mxn("xrp_mxn");
	
	private String currency;
	
	BitsoCurrencies(String currency){
		this.currency = currency;
	}

}
