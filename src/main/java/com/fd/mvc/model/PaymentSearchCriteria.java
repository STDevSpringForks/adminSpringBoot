package com.fd.mvc.model;


import java.io.Serializable;

/**
 * This is class is for formPayment.jsp
 * All attributes in String for Spring Validator
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

}
