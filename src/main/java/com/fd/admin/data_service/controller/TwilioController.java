package com.fd.admin.data_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fd.admin.data_service_api.TwilioService;
import com.fd.admin.model.criteria.TwilioSMSSearchCriteria;
import com.fd.admin.model.result.TwilioSMSResult;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping("")
public class TwilioController {
    
    @Autowired
    @Qualifier("twilioServiceImpl")
    private TwilioService twilioService;

    @RequestMapping(value = "/sendSMS", method = RequestMethod.POST)
    public TwilioSMSResult sendSMS(@RequestBody TwilioSMSSearchCriteria searchCriteria) {
        return twilioService.sendSMS(searchCriteria);
    }
    
}