package com.fd.mvc.model;

import com.fd.mvc.model.BitsoPayloadOrderBook;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderBook implements Serializable{

	private static final long serialVersionUID = -2219364589608000040L;
	
	private boolean success;
	private BitsoPayloadOrderBook payload;
	
	public OrderBook() {
		this.payload = new BitsoPayloadOrderBook();
	}
	
}
