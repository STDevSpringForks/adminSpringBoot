package com.fd.admin.data_service.repository;

import com.fd.admin.model.criteria.JRClientsSearchCriteria;
import com.fd.admin.model.result.JRClientsResult;

/**
 * 
 * @author Muguruza
 *
 */
public interface JasperReportRepository {
	JRClientsResult generateClientsReport(JRClientsSearchCriteria searchCriteria);
}
