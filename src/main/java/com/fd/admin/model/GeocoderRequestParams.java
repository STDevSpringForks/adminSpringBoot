package com.fd.admin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Muguruza
 *
 */
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeocoderRequestParams [geocoderRequestList=");
		builder.append(geocoderRequestList);
		builder.append("]");
		return builder.toString();
	}
	

}
