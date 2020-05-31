package com.fd.mvc.model;

import com.fd.mvc.model.BitsoPayloadTicker;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class BitsoTicker implements Serializable {
	
	private static final long serialVersionUID = 1282407494420026551L;

	private boolean success;
	private List<BitsoPayloadTicker> payload;
	
	public BitsoTicker(){
		payload = new ArrayList<>();
	}


}
