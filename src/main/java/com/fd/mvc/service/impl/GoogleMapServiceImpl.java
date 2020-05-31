package com.fd.mvc.service.impl;

import com.fd.mvc.model.GeocoderErrorObject;
import com.fd.mvc.model.GeocoderRequest;
import com.fd.mvc.model.GeocoderRequestParams;
import com.fd.mvc.model.GeocoderResult;
import com.fd.mvc.service.GoogleMapService;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("googleMapService")
public class GoogleMapServiceImpl implements GoogleMapService {

	@Override
	public GeocoderResult retrieveGeocoding(GeocoderRequestParams geocoderRequestParams) {
		GeocoderResult geocoderResult = new GeocoderResult();
		
		
		List<GeocoderRequest> geocoderRequestList = geocoderRequestParams.getGeocoderRequestList();
		
		List<GeocodingResult[]> geocodingResultList = new ArrayList<>();		
		List<GeocoderErrorObject> geocoderErrorObjectList = new ArrayList<>();
		
		geocoderRequestList.forEach(geo ->{
			
			StringBuilder sbAddress = new StringBuilder();
			sbAddress.append(StringUtils.stripToEmpty(geo.getAddressLine1()).trim())
					 .append(StringUtils.stripToEmpty(geo.getAddressLine2()).trim())
					 .append(StringUtils.stripToEmpty(geo.getCity()).trim()).append(", ")
					 .append(StringUtils.stripToEmpty(geo.getState()).trim())
					 .append(StringUtils.stripToEmpty(geo.getZipCode()).trim())
					 .append(StringUtils.stripToEmpty(geo.getCounty()).trim());
			
			
	    	GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyBJG_vXFnG5Hvyw2QTaBLdAaGPHkSDwNMM").build();
			try {
				
				GeocodingResult[] results = GeocodingApi.geocode(context,sbAddress.toString()).await();
				
				if(results == null){
					throw new Exception("No data availabe.");
				}
				
				/*System.out.println(results[0].geometry.location.lat + " " + results[0].geometry.location.lng);*/
				
				geocodingResultList.add(results);
				
			} catch (Exception e) {
				GeocoderErrorObject geocoderErrorObject = new GeocoderErrorObject();
				
				/*geocoderErrorObject.setId(geo.getIdGeocoderRequest());*/
				geocoderErrorObject.setFormatAddress(sbAddress.toString());
				geocoderErrorObject.setErrorMessage(e.getMessage());
				
				geocoderErrorObjectList.add(geocoderErrorObject);
				
				log.error("Error in GeocodingApi.geocode: ", e);
			}
			
	    });
		
		geocoderResult.setGeocodingResultList(geocodingResultList);
		geocoderResult.setGeocoderErrorObjectList(geocoderErrorObjectList);
	    
		if(geocoderResult.getGeocodingResultList() != null){
			System.out.println(geocoderResult.getGeocodingResultList().size());
		}
		
		if(geocoderResult.getGeocoderErrorObjectList() != null){
			System.out.println(geocoderResult.getGeocoderErrorObjectList().size());
		}
		
		
		return geocoderResult;
	}

	@Override
	public GeocoderResult retrieveGeocoding(GeocoderRequest geocoderRequest) {
		
		GeocoderResult geocoderResult = new GeocoderResult();
		
		List<GeocodingResult[]> geocodingResultList = new ArrayList<>();		
		List<GeocoderErrorObject> geocoderErrorObjectList = new ArrayList<>();
		
		geocoderRequest.setAddressLine1(StringUtils.stripToEmpty(geocoderRequest.getAddressLine1()).trim());
		geocoderRequest.setAddressLine2(StringUtils.stripToEmpty(geocoderRequest.getAddressLine2()).trim());
		geocoderRequest.setCity(StringUtils.stripToEmpty(geocoderRequest.getCity()).trim());
		geocoderRequest.setState(StringUtils.stripToEmpty(geocoderRequest.getState()).trim());
		geocoderRequest.setZipCode(StringUtils.stripToEmpty(geocoderRequest.getZipCode()).trim());
		geocoderRequest.setCounty(StringUtils.stripToEmpty(geocoderRequest.getCounty()).trim());
		
		StringBuilder sbAddress = new StringBuilder();
		sbAddress.append(geocoderRequest.getAddressLine1())
				 .append(geocoderRequest.getAddressLine2())
				 .append(geocoderRequest.getCity()).append(", ")
				 .append(geocoderRequest.getState())
				 .append(geocoderRequest.getZipCode())
				 .append(geocoderRequest.getCounty());
		
		
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyBJG_vXFnG5Hvyw2QTaBLdAaGPHkSDwNMM").build();
		try {
			
			GeocodingResult[] results = GeocodingApi.geocode(context,sbAddress.toString()).await();
			
			if(results == null){
				throw new Exception("No data availabe.");
			}
			
			geocoderRequest.setLatitude(String.valueOf(results[0].geometry.location.lat));
			geocoderRequest.setLongitude(String.valueOf(results[0].geometry.location.lng));
			
			geocodingResultList.add(results);
			
		} catch (/*ApiException | InterruptedException | IOException e | */Exception e) {
			GeocoderErrorObject geocoderErrorObject = new GeocoderErrorObject();
			
			/*geocoderErrorObject.setId(geo.getIdGeocoderRequest());*/
			geocoderErrorObject.setFormatAddress(sbAddress.toString());
			geocoderErrorObject.setErrorMessage(e.getMessage());
			
			geocoderErrorObjectList.add(geocoderErrorObject);
			
			log.error("Error in GeocodingApi.geocode: ", e);
		}
		
		
		return geocoderResult;
	}
	
}
