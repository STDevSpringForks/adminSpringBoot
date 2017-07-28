package com.fd.admin.model;

import java.util.ArrayList;
import java.util.List;

import com.google.maps.model.GeocodingResult;

/**
 * Pojo para almacenar el resultado de la geocodificación.
 * https://developers.google.com/maps/documentation/javascript/geocoding?hl=es-419
 * @author Muguruza
 *
 */
public class GeocoderResult {

	private List<GeocodingResult[]> geocodingResultList;
	private List<GeocoderErrorObject> geocoderErrorObjectList;

	public GeocoderResult() {
		geocodingResultList = new ArrayList<>();
		geocoderErrorObjectList = new ArrayList<>();
	}

	public List<GeocodingResult[]> getGeocodingResultList() {
		return geocodingResultList;
	}

	public void setGeocodingResultList(List<GeocodingResult[]> geocodingResultList) {
		this.geocodingResultList = geocodingResultList;
	}

	public List<GeocoderErrorObject> getGeocoderErrorObjectList() {
		return geocoderErrorObjectList;
	}

	public void setGeocoderErrorObjectList(List<GeocoderErrorObject> geocoderErrorObjectList) {
		this.geocoderErrorObjectList = geocoderErrorObjectList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeocoderResult [geocodingResultList=");
		builder.append(geocodingResultList);
		builder.append(", geocoderErrorObjectList=");
		builder.append(geocoderErrorObjectList);
		builder.append("]");
		return builder.toString();
	}

	

	
}
