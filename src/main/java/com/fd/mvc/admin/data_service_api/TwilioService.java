package com.fd.mvc.admin.data_service_api;

import com.fd.mvc.admin.model.criteria.TwilioSMSSearchCriteria;
import com.fd.mvc.admin.model.result.TwilioSMSResult;

/**
 * 
 * @author Muguruza
 *
 */
public interface TwilioService {
    TwilioSMSResult sendSMS(TwilioSMSSearchCriteria searchCriteria);
}
