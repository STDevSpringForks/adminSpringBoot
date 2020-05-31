package com.fd.mvc.admin.data_service.service.impl;

import com.fd.mvc.admin.data_service_api.TwilioService;
import com.fd.mvc.admin.model.criteria.TwilioSMSSearchCriteria;
import com.fd.mvc.admin.model.result.TwilioSMSResult;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Muguruza
 *
 */
@Service("twilioServiceImpl")
public class TwilioServiceImpl implements TwilioService {

    // Find your Account SID and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "ACf80d1a5a1df618f374592337c360b450";
    public static final String AUTH_TOKEN = "bc8849f3d9fdb3ad35635068b676ef8e";
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioServiceImpl.class);

    @Override
    public TwilioSMSResult sendSMS(TwilioSMSSearchCriteria searchCriteria) {
        TwilioSMSResult twilioSMSResult = new TwilioSMSResult();
        
        StringBuilder sbPhone = new StringBuilder();
        searchCriteria.setAreaCodeCountry("+521"); //HardCode Mexico
        sbPhone.append(searchCriteria.getAreaCodeCountry());
        sbPhone.append(searchCriteria.getPhoneNumberTo());
        
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        
        Message message = Message.creator(new PhoneNumber(sbPhone.toString()), new PhoneNumber("+13477355250"),searchCriteria.getBody()).create();

        LOGGER.info(message.getSid());
        twilioSMSResult.setMessage(message);

        return twilioSMSResult;

    }

}
