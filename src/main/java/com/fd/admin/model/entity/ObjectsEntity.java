package com.fd.admin.model.entity;

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
@Table(name = "objetos")
public class ObjectsEntity implements Serializable {

	private static final long serialVersionUID = -2219691545855565664L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name = "objeto")
	private byte[] objeto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getObjecto() {
		return objeto;
	}

	public void setObjecto(byte[] objecto) {
		this.objeto = objecto;
	}
	
}