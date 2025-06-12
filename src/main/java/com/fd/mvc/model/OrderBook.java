package com.fd.mvc.model;

import com.fd.mvc.model.BitsoPayloadOrderBook;

import java.io.Serializable;

public class OrderBook implements Serializable{

	private static final long serialVersionUID = -2219364589608000040L;
	
	private boolean success;
	private BitsoPayloadOrderBook payload;
	
	public OrderBook() {
		this.payload = new BitsoPayloadOrderBook();
	}
	
    public boolean getSuccess() {
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

}
