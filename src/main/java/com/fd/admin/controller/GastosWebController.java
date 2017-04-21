package com.fd.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fd.adminHome.data_service.gastos.service.GastosService;
import com.fd.adminHome.model.gastos.criteria.GastosListDetailsSearchCriteria;
import com.fd.adminHome.model.gastos.result.GastosListDetailsResult;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping("/gastos")
public class GastosWebController {
	
	public static final String VIEW_FINANCE = "modules/finance/viewFinance";
	
	@Autowired
    private GastosService gastosService;
	
	@GetMapping("/g")
	public String viewFinance(){
		GastosListDetailsSearchCriteria searchCriteria = new GastosListDetailsSearchCriteria();
		GastosListDetailsResult result = gastosService.retrieveGastosListDetails(searchCriteria);
		
		System.out.println(result);
		
		return VIEW_FINANCE;
	}
	
	
}
