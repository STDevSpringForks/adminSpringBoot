package com.fd.mvc.admin.model.criteria;

import java.io.Serializable;

/**
 * 
 * @author Muguruza
 *
 */
public class PersonListDetailsSearchCriteria implements Serializable {
	
	private static final long serialVersionUID = -5035844337297853242L;
	
	private String fristName;
	private String lastName;
	
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonListDetailsSearchCriteria [fristName=");
		builder.append(fristName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
