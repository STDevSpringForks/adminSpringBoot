package com.fd.mvc.admin.data_service.validator;

import com.fd.mvc.admin.model.criteria.PaymentSearchCriteria;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * 
 * @author Muguruza
 *
 */
@Component
public class PaymentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PaymentValidator.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	PaymentSearchCriteria paymentSearchCriteria = (PaymentSearchCriteria) target;
    	
    	//Start Amount ------------------------
    	if(StringUtils.isNotBlank(paymentSearchCriteria.getAmount())){
    		BigDecimal amount = new BigDecimal(paymentSearchCriteria.getAmount());
    		try{
            	if(amount.compareTo(BigDecimal.ZERO) != 1){
            		errors.rejectValue("amount", "AmountMayorNumeric", "Amount should not <= 0");
            	}
            }catch(NumberFormatException nfe){
            	errors.rejectValue("amount", "AmountNumeric", "Amount must be numeric");
            }
    	}else{
    		errors.rejectValue("amount", "AmountRequired", "Amount should not be blank");
    	}
    	//End Amount ------------------------
    	
    	//Start Promo Code ------------------------
    	String promoCode = StringUtils.stripToEmpty(paymentSearchCriteria.getPromoCode());
    	if(promoCode.length() != 6){
    		errors.rejectValue("promoCode", "PromoCodeRequired", "Tiene que tener 6 caracteres");
    	}
    	//End Promo Code ------------------------
        
    }

}
