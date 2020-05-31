package com.fd.mvc.model;

import com.google.maps.model.GeocodingResult;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Pojo para almacenar el resultado de la geocodificación.
 * https://developers.google.com/maps/documentation/javascript/geocoding?hl=es-419
 *
 */
@Data
public class GeocoderResult {

	private List<GeocodingResult[]> geocodingResultList;
	private List<GeocoderErrorObject> geocoderErrorObjectList;

	public GeocoderResult() {
		geocodingResultList = new ArrayList<>();
		geocoderErrorObjectList = new ArrayList<>();
	}

}
