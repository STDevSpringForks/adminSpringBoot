package com.fd.admin.data_service.service.impl;

import org.springframework.stereotype.Service;

import com.fd.admin.data_service_api.JasperReportService;
import com.fd.admin.model.criteria.JRClientsSearchCriteria;

/**
 * 
 * @author Muguruza
 *
 */
@Service("jasperReportServiceImpl")
public class JasperReportServiceImpl implements JasperReportService {

	@Override
	public byte[] generateClientsReport(JRClientsSearchCriteria searchCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
