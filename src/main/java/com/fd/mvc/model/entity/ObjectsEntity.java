package com.fd.mvc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
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

}
