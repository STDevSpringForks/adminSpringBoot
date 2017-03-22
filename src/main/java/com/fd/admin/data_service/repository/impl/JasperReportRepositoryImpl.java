package com.fd.admin.data_service.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.fd.admin.data_service.repository.JasperReportRepository;
import com.fd.admin.model.criteria.JRClientsSearchCriteria;
import com.fd.admin.model.result.JRClientsResult;

/**
 * 
 * @author Muguruza
 *
 */
@Repository
public class JasperReportRepositoryImpl implements JasperReportRepository {

	@Autowired
	Environment env;
	
//	@Autowired
//	@Qualifier("exampleServiceImpl")
//	private ExampleService exampleService;
	
	@Override
	public JRClientsResult generateClientsReport(JRClientsSearchCriteria searchCriteria) {
		// TODO Call Hibernate
		return null;
	}

}
