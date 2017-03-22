package com.fd.admin.data_service_api;

import com.fd.admin.model.criteria.JRClientsSearchCriteria;

/**
 * 
 * @author Muguruza
 *
 */
public interface JasperReportService {
	byte[] generateClientsReport(JRClientsSearchCriteria searchCriteria);
}
