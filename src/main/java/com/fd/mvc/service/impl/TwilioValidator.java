package com.fd.mvc.service.impl;

import com.fd.mvc.model.TwilioSMSSearchCriteria;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TwilioValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return TwilioSMSSearchCriteria.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TwilioSMSSearchCriteria twilioSMSSearchCriteria = (TwilioSMSSearchCriteria) target;
        
        //Start phoneNumberTO
        String phoneNumberTo = StringUtils.stripToEmpty(twilioSMSSearchCriteria.getPhoneNumberTo());
        if(StringUtils.isBlank(phoneNumberTo)){
            errors.rejectValue("phoneNumberTo", "PhoneNumberToRequired", "PhoneNumberTo is required");
        }else{
        	if(phoneNumberTo.length() != 10){
        		errors.rejectValue("phoneNumberTo", "PhoneNumberToLength", "PhoneNumberTo must be 10 digits");
        	}
        }
        //End phoneNumberTO
        
        //Start message
        String message = StringUtils.stripToEmpty(twilioSMSSearchCriteria.getBody());
        if(StringUtils.isBlank(message)){
            errors.rejectValue("body", "MessageRequired", "Message is required");
        }
        //End message
        
    }
    
}
