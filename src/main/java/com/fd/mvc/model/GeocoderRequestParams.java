package com.fd.mvc.model;


import java.util.ArrayList;
import java.util.List;

public class GeocoderRequestParams {
	
	List<GeocoderRequest> geocoderRequestList;

	public GeocoderRequestParams() {
		geocoderRequestList = new ArrayList<>();

	}

	public List<GeocoderRequest> getGeocoderRequestList() {
		return geocoderRequestList;
	}

	public void setGeocoderRequestList(List<GeocoderRequest> geocoderRequestList) {
		this.geocoderRequestList = geocoderRequestList;
	}
}
