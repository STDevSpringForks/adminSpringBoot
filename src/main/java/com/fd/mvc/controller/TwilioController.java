package com.fd.mvc.controller;

import com.fd.mvc.service.TwilioService;
import com.fd.mvc.model.TwilioSMSSearchCriteria;
import com.fd.mvc.model.TwilioSMSResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("")
public class TwilioController {

    private final TwilioService twilioService;

    @RequestMapping(value = "/sendSMS", method = RequestMethod.POST)
    public TwilioSMSResult sendSMS(@RequestBody TwilioSMSSearchCriteria searchCriteria) {
        return twilioService.sendSMS(searchCriteria);
    }

}
