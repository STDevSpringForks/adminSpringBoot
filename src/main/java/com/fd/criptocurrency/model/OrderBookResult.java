package com.fd.criptocurrency.model;

import java.io.Serializable;

import com.fd.admin.data_service.criptomonedas.bisto.BitsoPayloadOrderBook;

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
