package com.fd.admin.model.internet.entity;

import javax.persistence.Column;
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
@Table(name = "InternetEmailAccounts")
public class InternetEmailAccounts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idInternetEmailAccounts")
	private int idInternetEmailAccounts;
	
	@Column(name = "email")
	private String email;
	
	public InternetEmailAccounts() {
	}
	
	public InternetEmailAccounts(String email) {
		this.email = email;
	}

	public int getIdInternetEmailAccounts() {
		return idInternetEmailAccounts;
	}
	public void setIdInternetEmailAccounts(int idInternetEmailAccounts) {
		this.idInternetEmailAccounts = idInternetEmailAccounts;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InternetEmailAccounts [idInternetEmailAccounts=");
		builder.append(idInternetEmailAccounts);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
}
