package com.fd.mvc.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Bids implements Serializable {
	
	private static final long serialVersionUID = -8390148359553970741L;
	
	private String book;
	private String price;
	private String amount;
	
}
