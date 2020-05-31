package com.fd.mvc.model;

import com.fd.mvc.model.BitsoPayloadTicker;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
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
	
}
