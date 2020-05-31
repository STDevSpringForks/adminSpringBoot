package com.fd.mvc.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BitsoPayloadTicker implements Serializable {
	
	private static final long serialVersionUID = 3463390799122555749L;
	
	private String high;
	private String last;
	private String created_at;
	private String book;
	private String volume;
	private String vwap;
	private String low;
	private String ask;
	private String bid;

}
