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
@Table(name = "exchanges")
public class ExchangeEntity implements Serializable {

	private static final long serialVersionUID = -303795993514143414L;
	
	private long rid;
	private String name;
	
	@Id
	@Column(name = "rid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExchangeEntity [rid=");
		builder.append(rid);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
}