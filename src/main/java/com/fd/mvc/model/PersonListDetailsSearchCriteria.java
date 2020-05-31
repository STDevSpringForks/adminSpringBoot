package com.fd.mvc.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonListDetailsSearchCriteria implements Serializable {
	
	private static final long serialVersionUID = -5035844337297853242L;
	
	private String fristName;
	private String lastName;
	
}
