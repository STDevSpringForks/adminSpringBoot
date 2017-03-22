package com.fd.admin.data_service.service.impl;

import org.springframework.stereotype.Service;

import com.fd.admin.data_service_api.BitsoService;


/**
 * 
 * @author Muguruza
 *
 */
@Service("bitsoServiceImpl")
public class BitsoServiceImpl implements BitsoService {

	String bitsoKey = "BITSO API KEY";
    String bitsoSecret = "BITSO API SECRET";
    String bitsoClientId = "BITSO CLIENT ID";
	
	@Override
	public void testing() {
		
		
	}
	
}