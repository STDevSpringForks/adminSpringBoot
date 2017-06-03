package com.fd.criptocurrency.model.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fd.admin.data_service.criptomonedas.bisto.BitsoPayload;

/**
 * 
 * @author Muguruza
 *
 */
public class BitsoPayloadResult implements Serializable {
	
	private static final long serialVersionUID = 4706397058743533390L;
	
	private List<BitsoPayload> bitsoPayloadList;
	private Map<String,BitsoPayload> books;
	
	private BitsoPayload payloadETH_MXN;
	private BitsoPayload payloadXRP_MXN;
	private BitsoPayload payloadBTC_MXN;

	public BitsoPayloadResult(){
		this.bitsoPayloadList = new ArrayList<>();
		this.books = new HashMap<>();
		this.payloadETH_MXN = new BitsoPayload();
		this.payloadXRP_MXN = new BitsoPayload();
		this.payloadBTC_MXN = new BitsoPayload();
	}
	
	public List<BitsoPayload> getBitsoPayloadList() {
		return bitsoPayloadList;
	}
	public void setBitsoPayloadList(List<BitsoPayload> bitsoPayloadList) {
		this.bitsoPayloadList = bitsoPayloadList;
	}
	public Map<String, BitsoPayload> getBooks() {
		return books;
	}

	public void setBooks(Map<String, BitsoPayload> books) {
		this.books = books;
	}
	public BitsoPayload getPayloadETH_MXN() {
		return payloadETH_MXN;
	}
	public void setPayloadETH_MXN(BitsoPayload payloadETH_MXN) {
		this.payloadETH_MXN = payloadETH_MXN;
	}
	public BitsoPayload getPayloadXRP_MXN() {
		return payloadXRP_MXN;
	}
	public void setPayloadXRP_MXN(BitsoPayload payloadXRP_MXN) {
		this.payloadXRP_MXN = payloadXRP_MXN;
	}
	public BitsoPayload getPayloadBTC_MXN() {
		return payloadBTC_MXN;
	}
	public void setPayloadBTC_MXN(BitsoPayload payloadBTC_MXN) {
		this.payloadBTC_MXN = payloadBTC_MXN;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BitsoPayloadResult [bitsoPayloadList=");
		builder.append(bitsoPayloadList);
		builder.append(", books=");
		builder.append(books);
		builder.append(", payloadETH_MXN=");
		builder.append(payloadETH_MXN);
		builder.append(", payloadXRP_MXN=");
		builder.append(payloadXRP_MXN);
		builder.append(", payloadBTC_MXN=");
		builder.append(payloadBTC_MXN);
		builder.append("]");
		return builder.toString();
	}

}