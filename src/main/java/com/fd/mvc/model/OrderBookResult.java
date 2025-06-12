package com.fd.mvc.model;

import com.fd.mvc.model.BitsoPayloadOrderBook;

import java.io.Serializable;

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

}
