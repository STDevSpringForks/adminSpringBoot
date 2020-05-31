package com.fd.mvc.common;

import java.math.BigDecimal;

public interface BitsoConstants {

	String BITSO_URL_TICKER = "https://api.bitso.com/v3/ticker/";
	String BITSO_URL_ORDER_BOOK_ETH_MXN = "https://api.bitso.com/v3/order_book/?book=eth_mxn";
	String BITSO_URL_ORDER_BOOK_ETH_MXN_FULL = "https://api.bitso.com/v3/order_book/?book=eth_mxn&aggregate=false";
	BigDecimal COMISION_TRADE = new BigDecimal("0.01");

}
