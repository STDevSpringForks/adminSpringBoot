package com.fd.mvc.service;

import com.fd.mvc.model.TwilioSMSSearchCriteria;
import com.fd.mvc.model.TwilioSMSResult;

public interface TwilioService {
    TwilioSMSResult sendSMS(TwilioSMSSearchCriteria searchCriteria);
}
