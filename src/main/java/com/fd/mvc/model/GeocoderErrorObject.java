package com.fd.mvc.model;

import lombok.Data;

@Data
public class GeocoderErrorObject {

	private int id;
	private String formatAddress;
	private String errorMessage;
	

}
