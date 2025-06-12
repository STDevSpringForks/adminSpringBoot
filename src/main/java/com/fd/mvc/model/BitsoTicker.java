package com.fd.mvc.model;

import com.fd.mvc.model.BitsoPayloadTicker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BitsoTicker implements Serializable {
	
	private static final long serialVersionUID = 1282407494420026551L;

	private boolean success;
	private List<BitsoPayloadTicker> payload;
	
	public BitsoTicker(){
		payload = new ArrayList<>();
	}


    public boolean getSuccess() {
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

}
