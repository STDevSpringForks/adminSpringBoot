package com.fd.mvc.criptocurrency.model;

import com.fd.mvc.admin.data_service.criptomonedas.bisto.BitsoPayloadOrderBook;

import java.io.Serializable;

/**
 * 
 * @author Muguruza
 *
 */
public class OrderBookResult implements Serializable {

	private static final long serialVersionUID = 8786113471628401360L;
	
	private BitsoPayloadOrderBook bitsoPayloadOrderBook;

	public OrderBookResult() {
		this.bitsoPayloadOrderBook = new BitsoPayloadOrderBook();
	}


	public BitsoPayloadOrderBook getBitsoPayloadOrderBook() {
		return bitsoPayloadOrderBook;
	}

	public void setBitsoPayloadOrderBook(BitsoPayloadOrderBook bitsoPayloadOrderBook) {
		this.bitsoPayloadOrderBook = bitsoPayloadOrderBook;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderBookResult [bitsoPayloadOrderBook=");
		builder.append(bitsoPayloadOrderBook);
		builder.append("]");
		return builder.toString();
	}
	
}
