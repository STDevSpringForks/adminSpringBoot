package com.fd.admin.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Muguruza
 *
 */
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

	public int getIdGeocoderRequest() {
		return idGeocoderRequest;
	}
	public void setIdGeocoderRequest(int idGeocoderRequest) {
		this.idGeocoderRequest = idGeocoderRequest;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeocoderRequest [idGeocoderRequest=");
		builder.append(idGeocoderRequest);
		builder.append(", addressLine1=");
		builder.append(addressLine1);
		builder.append(", addressLine2=");
		builder.append(addressLine2);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", county=");
		builder.append(county);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append("]");
		return builder.toString();
	}

}