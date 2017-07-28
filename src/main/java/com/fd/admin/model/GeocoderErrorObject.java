package com.fd.admin.model;

/**
 * 
 * @author Muguruza
 *
 */
public class GeocoderErrorObject {

	private int id;
	private String formatAddress;
	private String errorMessage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFormatAddress() {
		return formatAddress;
	}
	public void setFormatAddress(String formatAddress) {
		this.formatAddress = formatAddress;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeocoderErrorObject [id=");
		builder.append(id);
		builder.append(", formatAddress=");
		builder.append(formatAddress);
		builder.append(", errorMessage=");
		builder.append(errorMessage);
		builder.append("]");
		return builder.toString();
	}
	
}
