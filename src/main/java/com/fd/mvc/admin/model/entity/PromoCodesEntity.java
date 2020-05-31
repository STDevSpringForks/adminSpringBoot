package com.fd.mvc.admin.model.entity;

import javax.persistence.*;

/**
 * Class for Hibernate.
 * @author Muguruza
 *
 */
@Entity
@Table(name = "promo_codes")
public class PromoCodesEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "promo_code")
	private String promoCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	
	
}
