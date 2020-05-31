package com.fd.mvc.admin.data_service.criptomonedas.bisto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Muguruza
 *
 */
public class BitsoTicker implements Serializable {
	
	private static final long serialVersionUID = 1282407494420026551L;
	private boolean success;
	
	private List<BitsoPayloadTicker> payload;
	
	public BitsoTicker(){
		payload = new ArrayList<>();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<BitsoPayloadTicker> getPayload() {
		return payload;
	}

	public void setPayload(List<BitsoPayloadTicker> payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BitsoTicker [success=");
		builder.append(success);
		builder.append(", payload=");
		builder.append(payload);
		builder.append("]");
		return builder.toString();
	}
	
	
}
