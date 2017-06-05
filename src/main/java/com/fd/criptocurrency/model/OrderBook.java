package com.fd.criptocurrency.model;

import java.io.Serializable;

import com.fd.admin.data_service.criptomonedas.bisto.BitsoPayloadOrderBook;

/**
 * 
 * @author Muguruza
 *
 */
public class OrderBook implements Serializable{

	private static final long serialVersionUID = -2219364589608000040L;
	
	private boolean success;
	private BitsoPayloadOrderBook payload;
	
	public OrderBook() {
		this.payload = new BitsoPayloadOrderBook();
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public BitsoPayloadOrderBook getPayload() {
		return payload;
	}

	public void setPayload(BitsoPayloadOrderBook payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderBook [success=");
		builder.append(success);
		builder.append(", payload=");
		builder.append(payload);
		builder.append("]");
		return builder.toString();
	}
	
}
