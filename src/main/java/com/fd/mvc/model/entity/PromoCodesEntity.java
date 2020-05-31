package com.fd.mvc.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "promo_codes")
public class PromoCodesEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "promo_code")
	private String promoCode;

}
