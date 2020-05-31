package com.fd.mvc.admin.data_service_api;

import com.fd.mvc.admin.model.GeocoderRequest;
import com.fd.mvc.admin.model.GeocoderRequestParams;
import com.fd.mvc.admin.model.GeocoderResult;

public interface GoogleMapService {

    /**
     * https://developers.google.com/maps/documentation/javascript/geocoding?hl=esn-419 :: Límites y políticas de uso
     * 2500 solicitudes gratis por día y 50 solicitudes por segundo.
     * <p>
     * La geocodificación es el proceso que convierte direcciones (como “1600 Amphitheatre Parkway, Mountain View, CA”)
     * en coordenadas geográficas (como latitud 37,423021 y longitud -122,083739)
     * que puedes usar para disponer marcadores o posicionar el mapa.
     *
     * @return
     */
    GeocoderResult retrieveGeocoding(GeocoderRequestParams geocoderRequestParams);

    GeocoderResult retrieveGeocoding(GeocoderRequest geocoderRequest);

}
