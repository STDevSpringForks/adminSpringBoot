package com.fd.mvc.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "geocoderrequest")
public class GeocoderRequest implements Serializable {

	private static final long serialVersionUID = 2522973474804711107L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGeocoderRequest;
	
	/* Default attributes */
	private String addressLine1; 	/* 7167 KOCH RD */
	private String addressLine2;
	private String city; 			/* SAINT JAMES */
	private String state; 			/* LA */
	private String zipCode; 		/* 70086-7371 */
	private String county; 			/* ST JAMES */
	
	//new parameters
	private String latitude;
	private String longitude;
	
	public GeocoderRequest() {
	}
	
	public GeocoderRequest(int idGeocoderRequest,String addressLine1, String addressLine2, String city, String state, String zipCode,	String county,String latitude,String longitude) {
		this.idGeocoderRequest = idGeocoderRequest;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.county = county;
		
		this.latitude = latitude;
		this.longitude = longitude;
	}

}
