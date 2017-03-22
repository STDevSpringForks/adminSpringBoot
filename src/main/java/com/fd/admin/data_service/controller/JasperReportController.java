package com.fd.admin.data_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fd.admin.data_service_api.JasperReportService;
import com.fd.admin.model.criteria.JRClientsSearchCriteria;

/**
 * 
 * @author Muguruza
 *
 */
@RestController
@RequestMapping("")
public class JasperReportController {

	@Autowired
	@Qualifier("jasperReportServiceImpl")
	private JasperReportService jasperReportService;

	@RequestMapping(value = "/generateClientsReport", method = RequestMethod.POST)
	public byte[] generateClientsReport(@RequestBody JRClientsSearchCriteria searchCriteria) {
		return jasperReportService.generateClientsReport(searchCriteria);
	}

}
