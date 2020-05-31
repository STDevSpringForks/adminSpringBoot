package com.fd.mvc.admin.data_service.controller;

import com.fd.mvc.admin.data_service_api.TwilioService;
import com.fd.mvc.admin.model.criteria.TwilioSMSSearchCriteria;
import com.fd.mvc.admin.model.result.TwilioSMSResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@AllArgsConstructor
@Controller
@RequestMapping("")
public class TwilioController {
    
    private final TwilioService twilioService;

    @RequestMapping(value = "/sendSMS", method = RequestMethod.POST)
    public TwilioSMSResult sendSMS(@RequestBody TwilioSMSSearchCriteria searchCriteria) {
        return twilioService.sendSMS(searchCriteria);
    }
    
}
