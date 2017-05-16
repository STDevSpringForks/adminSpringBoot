package com.fd.criptocurrency.model.entity;

import java.io.Serializable;

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
@Table(name = "faucets")
public class FaucetEntity implements Serializable {
	
	private static final long serialVersionUID = 2230077328799317720L;
	
	private long rid;
	private String urlReferido;
	private String faucetUser;
	private String faucetPassword;
	private long ridAddressCurrency;
	
	@Id
	@Column(name = "rid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public String getUrlReferido() {
		return urlReferido;
	}
	public void setUrlReferido(String urlReferido) {
		this.urlReferido = urlReferido;
	}
	public String getFaucetUser() {
		return faucetUser;
	}
	public void setFaucetUser(String faucetUser) {
		this.faucetUser = faucetUser;
	}
	public String getFaucetPassword() {
		return faucetPassword;
	}
	public void setFaucetPassword(String faucetPassword) {
		this.faucetPassword = faucetPassword;
	}
	public long getRidAddressCurrency() {
		return ridAddressCurrency;
	}
	public void setRidAddressCurrency(long ridAddressCurrency) {
		this.ridAddressCurrency = ridAddressCurrency;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FaucetEntity [rid=");
		builder.append(rid);
		builder.append(", urlReferido=");
		builder.append(urlReferido);
		builder.append(", faucetUser=");
		builder.append(faucetUser);
		builder.append(", faucetPassword=");
		builder.append(faucetPassword);
		builder.append(", ridAddressCurrency=");
		builder.append(ridAddressCurrency);
		builder.append("]");
		return builder.toString();
	}
	
}