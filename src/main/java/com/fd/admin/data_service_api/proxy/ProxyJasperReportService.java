package com.fd.admin.data_service_api.proxy;

//import static com.fd.admin.model.AdminConstants.ENDPOINT_ADMIN_SERVICE_DATA;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.fd.admin.data_service_api.JasperReportService;
//import com.fd.admin.model.criteria.JRClientsSearchCriteria;

/**
 * 
 * @author Muguruza
 *
 */
//@Service
//public class ProxyJasperReportService implements JasperReportService {
//
//	@Autowired
//	private Environment env;
//	
//	@Autowired
//	RestTemplate restTemplate;
//	
//	@Override
//	public byte[] generateClientsReport(JRClientsSearchCriteria searchCriteria) {
//		return restTemplate.postForObject(env.getProperty(ENDPOINT_ADMIN_SERVICE_DATA).concat("generateClientsReport"), searchCriteria, byte[].class);
//	}
//
//}
