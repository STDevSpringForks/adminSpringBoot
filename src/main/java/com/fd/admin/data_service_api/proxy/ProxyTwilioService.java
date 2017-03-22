//package com.fd.admin.data_service_api.proxy;
//
//import static com.fd.admin.model.AdminConstants.ENDPOINT_ADMIN_SERVICE_DATA;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.fd.admin.data_service_api.TwilioService;
//import com.fd.admin.model.criteria.TwilioSMSCriteria;
//import com.fd.admin.model.result.TwilioSMSResult;
//
///**
// * 
// * @author Muguruza
// *
// */
//@Service
//public class ProxyTwilioService implements TwilioService {
//    
//    @Autowired
//    private Environment env;
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    @Override
//    public TwilioSMSResult sendSMS(TwilioSMSCriteria searchCriteria) {
//        return restTemplate.postForObject(env.getProperty(ENDPOINT_ADMIN_SERVICE_DATA).concat("sendSMS"),
//                searchCriteria, TwilioSMSResult.class);
//    }
//    
//}
