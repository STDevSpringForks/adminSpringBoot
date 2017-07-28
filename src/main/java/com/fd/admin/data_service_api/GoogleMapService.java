package com.fd.admin.data_service_api;

import com.fd.admin.model.GeocoderRequest;
import com.fd.admin.model.GeocoderRequestParams;
import com.fd.admin.model.GeocoderResult;

/**
 * 
 * @author Muguruza
 *
 */
public interface GoogleMapService {
	
	/**
	 * https://developers.google.com/maps/documentation/javascript/geocoding?hl=esn-419 :: Límites y políticas de uso
	 * 2500 solicitudes gratis por día y 50 solicitudes por segundo.
	 * 
	 * La geocodificación es el proceso que convierte direcciones (como “1600 Amphitheatre Parkway, Mountain View, CA”) 
	 * en coordenadas geográficas (como latitud 37,423021 y longitud -122,083739) 
	 * que puedes usar para disponer marcadores o posicionar el mapa.
	 * @return
	 */
	public GeocoderResult retrieveGeocoding(GeocoderRequestParams geocoderRequestParams);
	
	/**
	 * 
	 * @param addressFormat [addressLine1 addressLine2 city, state zipCode county]
	 * @return
	 */
	public GeocoderResult retrieveGeocoding(GeocoderRequest geocoderRequest);
	
}
