package com.fd.mvc.model.entity;


import javax.persistence.*;
import java.io.Serializable;

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

    public byte[] getObjeto() {
        return objeto;
    }

    public void setObjeto(byte[] objeto) {
        this.objeto = objeto;
    }

}
