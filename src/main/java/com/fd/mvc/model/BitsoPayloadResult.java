package com.fd.mvc.model;

import com.fd.mvc.model.BitsoPayloadTicker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitsoPayloadResult implements Serializable {
	
	private static final long serialVersionUID = 4706397058743533390L;
	
	private List<BitsoPayloadTicker> bitsoPayloadList;
	private Map<String,BitsoPayloadTicker> books;
	
	private BitsoPayloadTicker payloadETH_MXN;
	private BitsoPayloadTicker payloadXRP_MXN;
	private BitsoPayloadTicker payloadBTC_MXN;

	public BitsoPayloadResult(){
		this.bitsoPayloadList = new ArrayList<>();
		this.books = new HashMap<>();
		this.payloadETH_MXN = new BitsoPayloadTicker();
		this.payloadXRP_MXN = new BitsoPayloadTicker();
		this.payloadBTC_MXN = new BitsoPayloadTicker();
	}
	
    public List<BitsoPayloadTicker> getBitsoPayloadList() {
        return bitsoPayloadList;
    }

    public void setBitsoPayloadList(List<BitsoPayloadTicker> bitsoPayloadList) {
        this.bitsoPayloadList = bitsoPayloadList;
    }

    public Map<String,BitsoPayloadTicker> getBooks() {
        return books;
    }

    public void setBooks(Map<String,BitsoPayloadTicker> books) {
        this.books = books;
    }

    public BitsoPayloadTicker getPayloadETH_MXN() {
        return payloadETH_MXN;
    }

    public void setPayloadETH_MXN(BitsoPayloadTicker payloadETH_MXN) {
        this.payloadETH_MXN = payloadETH_MXN;
    }

    public BitsoPayloadTicker getPayloadXRP_MXN() {
        return payloadXRP_MXN;
    }

    public void setPayloadXRP_MXN(BitsoPayloadTicker payloadXRP_MXN) {
        this.payloadXRP_MXN = payloadXRP_MXN;
    }

    public BitsoPayloadTicker getPayloadBTC_MXN() {
        return payloadBTC_MXN;
    }

    public void setPayloadBTC_MXN(BitsoPayloadTicker payloadBTC_MXN) {
        this.payloadBTC_MXN = payloadBTC_MXN;
    }

}
