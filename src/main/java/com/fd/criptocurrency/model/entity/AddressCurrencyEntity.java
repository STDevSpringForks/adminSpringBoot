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
@Table(name = "addressCurrency")
public class AddressCurrencyEntity implements Serializable {

	private static final long serialVersionUID = 6613413272865969775L;
	
	private long rid;
	private String address;
	private long ridExchange;
	
	@Id
	@Column(name = "rid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getRidExchange() {
		return ridExchange;
	}
	public void setRidExchange(long ridExchange) {
		this.ridExchange = ridExchange;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddressCurrencyEntity [rid=");
		builder.append(rid);
		builder.append(", address=");
		builder.append(address);
		builder.append(", ridExchange=");
		builder.append(ridExchange);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
