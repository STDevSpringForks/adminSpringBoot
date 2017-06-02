package com.fd.criptocurrency.model.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fd.admin.data_service.criptomonedas.bisto.BitsoPayload;

/**
 * 
 * @author Muguruza
 *
 */
public class BitsoPayloadResult implements Serializable {
	
	private static final long serialVersionUID = 4706397058743533390L;
	
	private List<BitsoPayload> bitsoPayloadList;

	public BitsoPayloadResult(){
		this.bitsoPayloadList = new ArrayList<>();
	}
	
	public List<BitsoPayload> getBitsoPayloadList() {
		return bitsoPayloadList;
	}

	public void setBitsoPayloadList(List<BitsoPayload> bitsoPayloadList) {
		this.bitsoPayloadList = bitsoPayloadList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BitsoPayloadResult [bitsoPayloadList=");
		builder.append(bitsoPayloadList);
		builder.append("]");
		return builder.toString();
	}
	
}