package com.fd.mvc.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * This is class is for formPayment.jsp
 * We apply [[javax.validation]]
 * http://codetutr.com/2013/05/28/spring-mvc-form-validation/
 *
 */
public class PaymentValidSearchCriteria implements Serializable {
	
	private static final long serialVersionUID = 4988917470407813682L;
	
	@NotNull
	@DecimalMin(value = "1", message = "{Size.paymentSearchCriteria.promoCode}")
	@DecimalMax(value = "1000", message = "Price must not be higher than ${value}")
	//@Pattern(regexp="^[0-9]{4}$", message="Call is invalid.")
	private BigDecimal amount;
	
	@NotEmpty
	@Size(min=6, max=6, message="El codigo debe de ser de 6 caracteres.") 
	private String promoCode;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
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
		builder.append("PaymentValidSearchCriteria [amount=");
		builder.append(amount);
		builder.append(", promoCode=");
		builder.append(promoCode);
		builder.append("]");
		return builder.toString();
	}
	
}
