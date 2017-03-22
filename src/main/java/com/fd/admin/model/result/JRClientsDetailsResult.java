package com.fd.admin.model.result;

import java.io.Serializable;

/**
 * <p><b>This is a pojo to manage client details.</b></p>
 * <p>[JasperReports - clientsDetails.jrxml]</p>
 * <p><b>Note: </b></p>
 * <ul>
 *    <li>Send the attributes already set as it should be displayed in the report. (String)</li>
 * </ul>
 * @author Muguruza
 */
public class JRClientsDetailsResult implements Serializable {
	
	private static final long serialVersionUID = -5546966622588795406L;
	
	private String name;
	private String lastName;
	private String email;
	private String cellPhoneNumber;
	private String birthdate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}
	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JRClientsDetailsResult [name=");
		builder.append(name);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", cellPhoneNumber=");
		builder.append(cellPhoneNumber);
		builder.append(", birthdate=");
		builder.append(birthdate);
		builder.append("]");
		return builder.toString();
	}
	
}