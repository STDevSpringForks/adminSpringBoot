package com.fd.admin.model.criteria;

import java.io.Serializable;

/**
 * This is class is for formPayment.jsp
 * All attributes in String for Spring Validator
 * @author Muguruza
 *
 */
public class PaymentSearchCriteria implements Serializable {
	
	private static final long serialVersionUID = 4988917470407813682L;
	
	private String amount;
	private String promoCode;
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentSearchCriteria [amount=");
		builder.append(amount);
		builder.append(", promoCode=");
		builder.append(promoCode);
		builder.append("]");
		return builder.toString();
	}
	
}