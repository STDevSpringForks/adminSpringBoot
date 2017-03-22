package com.fd.admin.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fd.admin.data_service.validator.TwilioValidator;
import com.fd.admin.data_service_api.TwilioService;
import com.fd.admin.model.criteria.TwilioSMSSearchCriteria;
import com.fd.admin.model.result.TwilioSMSResult;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping("/twilio")
public class TwilioWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioWebController.class);
    private static final String VIEW_TIWILIO_SMS = "twilio/viewTiwilioSMS";

    @Autowired
    TwilioService twilioService;
    
    @Autowired
    TwilioValidator twilioValidator;
    
    /**
     * This is a form Tiwilio SMS.
     * @param model
     * @return
     */
    @GetMapping("/viewTiwilioSMS")
    public String viewTiwilioSMS(Model model) {
        TwilioSMSSearchCriteria twilioSMSSearchCriteria = new TwilioSMSSearchCriteria();
        model.addAttribute("twilioSMSSearchCriteria", twilioSMSSearchCriteria);
        return VIEW_TIWILIO_SMS;
    }
    
    /**
     * Process Tiwilio SMS.
     * @param twilioSMSSearchCriteria
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/viewTiwilioSMS")
    public String processTiwilioSMS(@ModelAttribute("twilioSMSSearchCriteria") TwilioSMSSearchCriteria twilioSMSSearchCriteria, BindingResult result, Model model) {
        
    	String phoneNumberTo = StringUtils.stripToEmpty(twilioSMSSearchCriteria.getPhoneNumberTo());
    	phoneNumberTo = phoneNumberTo.replaceAll("[^0-9]",""); //Remove different characters that number. 
    	twilioSMSSearchCriteria.setPhoneNumberTo(phoneNumberTo);
    	
        try {
            twilioValidator.validate(twilioSMSSearchCriteria, result);
            if (result.hasErrors()) {
                return VIEW_TIWILIO_SMS;
            }
            
            TwilioSMSResult twilioSMSResult = twilioService.sendSMS(twilioSMSSearchCriteria);
            model.addAttribute("msgResult", twilioSMSResult.getMessage());

        } catch (Exception e) {
            LOGGER.debug("Exception processTiwilioSMS", e);
            result.addError(new ObjectError("exception", e.getMessage()));
        }
        
        return VIEW_TIWILIO_SMS;
    }
    
}
