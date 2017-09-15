//package com.fd.admin;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.batch.item.ItemProcessor;
//
//import com.fd.admin.model.GeocoderRequest;
//
//public class GeocoderRequestItemProccessor implements ItemProcessor<GeocoderRequest,GeocoderRequest> {
//
//	 private static final Logger log = LoggerFactory.getLogger(GeocoderRequestItemProccessor.class);
//
//	    @Override
//	    public GeocoderRequest process(GeocoderRequest item) throws Exception {
//
//	        int idGeocoderRequest = item.getIdGeocoderRequest();
//	        
//	        String addressLine1 = item.getAddressLine1().toUpperCase();
//	        String addressLine2 = item.getAddressLine2().toUpperCase();
//	        String city = item.getCity().toUpperCase();
//	        String state = item.getState().toUpperCase();
//	        String zipCode = item.getZipCode().toUpperCase();
//	        String county = item.getCounty().toUpperCase();
//	        
//	        String latitude = item.getLatitude().toUpperCase();
//	        String longitude = item.getLongitude().toUpperCase();
//	        
//	        GeocoderRequest userProcess = new GeocoderRequest(idGeocoderRequest, addressLine1, addressLine2, city, state, zipCode, county, latitude, longitude);
//
//	        return userProcess;
//	    }
//	
//}
