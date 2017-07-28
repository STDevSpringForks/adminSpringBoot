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
@Table(name = "InternetPages")
public class InternetPages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idInternetPages")
	private int idInternetPages;
	
	@Column(name = "urlPage")
	private String urlPage;
	
	public InternetPages() {
	}
	public InternetPages(String urlPage) {
		this.urlPage = urlPage;
	}
	
	public int getIdInternetPages() {
		return idInternetPages;
	}
	public void setIdInternetPages(int idInternetPages) {
		this.idInternetPages = idInternetPages;
	}
	public String getUrlPage() {
		return urlPage;
	}
	public void setUrlPage(String urlPage) {
		this.urlPage = urlPage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InternetPages [idInternetPages=");
		builder.append(idInternetPages);
		builder.append(", urlPage=");
		builder.append(urlPage);
		builder.append("]");
		return builder.toString();
	}
	
}
