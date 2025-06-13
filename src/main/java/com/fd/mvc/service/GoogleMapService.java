package com.fd.mvc.service;

import com.fd.mvc.model.GeocoderRequest;
import com.fd.mvc.model.GeocoderRequestParams;
import com.fd.mvc.model.GeocoderResult;

public interface GoogleMapService {

    GeocoderResult retrieveGeocoding(GeocoderRequestParams geocoderRequestParams);
    GeocoderResult retrieveGeocoding(GeocoderRequest geocoderRequest);

}
