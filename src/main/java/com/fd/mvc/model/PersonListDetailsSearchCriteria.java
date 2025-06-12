package com.fd.mvc.model;


import java.io.Serializable;

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

}
