package com.fd.admin.springdata.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Muguruza
 *
 */
@Entity
@Table(name = "urlsocialnetwork")
public class UrlSocialNetwork {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idUrlSocialNetwork")
	private int idUrlSocialNetwork;
	
	@Column(name = "urlSocialNetwork")
	private String urlSocialNetwork;
	
	@ManyToOne /* Muchas urls pueden ser ligadas sólo a una persona. */
	@JoinColumn(name = "person_id") /* Unir la columna person_id con la clase entity columna. */
	private Persona persona;

	public int getIdUrlSocialNetwork() {
		return idUrlSocialNetwork;
	}

	public void setIdUrlSocialNetwork(int idUrlSocialNetwork) {
		this.idUrlSocialNetwork = idUrlSocialNetwork;
	}

	public String getUrlSocialNetwork() {
		return urlSocialNetwork;
	}

	public void setUrlSocialNetwork(String urlSocialNetwork) {
		this.urlSocialNetwork = urlSocialNetwork;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UrlSocialNetwork [idUrlSocialNetwork=");
		builder.append(idUrlSocialNetwork);
		builder.append(", urlSocialNetwork=");
		builder.append(urlSocialNetwork);
		builder.append(", persona=");
		builder.append(persona);
		builder.append("]");
		return builder.toString();
	}
	
	
}
