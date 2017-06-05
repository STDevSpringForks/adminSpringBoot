package com.fd.admin.data_service.criptomonedas.bisto;

import java.math.BigDecimal;

/**
 * Bitso constantes
 * @author Muguruza
 *
 */
public interface BitsoConstants {
	public static final String BITSO_URL_TICKER = "https://api.bitso.com/v3/ticker/";
	public static final String BITSO_URL_ORDER_BOOK_ETH_MXN = "https://api.bitso.com/v3/order_book/?book=eth_mxn";
	public static final String BITSO_URL_ORDER_BOOK_ETH_MXN_FULL = "https://api.bitso.com/v3/order_book/?book=eth_mxn&aggregate=false";
	public static final BigDecimal COMISION_TRADE = new BigDecimal("0.01");
}
