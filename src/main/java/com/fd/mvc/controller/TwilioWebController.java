package com.fd.mvc.controller;

import com.fd.mvc.service.impl.TwilioValidator;
import com.fd.mvc.service.TwilioService;
import com.fd.mvc.model.TwilioSMSSearchCriteria;
import com.fd.mvc.model.TwilioSMSResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.fd.mvc.common.Constants.VIEW_TIWILIO_SMS;

@Controller
@RequestMapping("/twilio")
public class TwilioWebController {

    private final TwilioService twilioService;
    private final TwilioValidator twilioValidator;

    private static final Logger log = LoggerFactory.getLogger(TwilioWebController.class);

    public TwilioWebController(TwilioService twilioService, TwilioValidator twilioValidator) {
        this.twilioService = twilioService;
        this.twilioValidator = twilioValidator;
    }
    
    @GetMapping("/viewTiwilioSMS")
    public String viewTiwilioSMS(Model model) {
        TwilioSMSSearchCriteria twilioSMSSearchCriteria = new TwilioSMSSearchCriteria();
        model.addAttribute("twilioSMSSearchCriteria", twilioSMSSearchCriteria);
        return VIEW_TIWILIO_SMS;
    }
    
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
            log.debug("Exception processTiwilioSMS", e);
            result.addError(new ObjectError("exception", e.getMessage()));
        }
        
        return VIEW_TIWILIO_SMS;
    }
    
}
