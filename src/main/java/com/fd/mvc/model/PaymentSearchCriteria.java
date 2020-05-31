package com.fd.mvc.model;

import lombok.Data;

import java.io.Serializable;

/**
 * This is class is for formPayment.jsp
 * All attributes in String for Spring Validator
 *
 */
@Data
public class PaymentSearchCriteria implements Serializable {
	
	private static final long serialVersionUID = 4988917470407813682L;
	
	private String amount;
	private String promoCode;
	
}
