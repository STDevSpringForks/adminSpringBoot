package com.fd.admin.data_service_api;

import com.fd.admin.model.criteria.TwilioSMSSearchCriteria;
import com.fd.admin.model.result.TwilioSMSResult;

/**
 * 
 * @author Muguruza
 *
 */
public interface TwilioService {
    TwilioSMSResult sendSMS(TwilioSMSSearchCriteria searchCriteria);
}
