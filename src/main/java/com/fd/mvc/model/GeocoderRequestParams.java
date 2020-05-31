package com.fd.mvc.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GeocoderRequestParams {
	
	List<GeocoderRequest> geocoderRequestList;

	public GeocoderRequestParams() {
		geocoderRequestList = new ArrayList<>();
	}


}
