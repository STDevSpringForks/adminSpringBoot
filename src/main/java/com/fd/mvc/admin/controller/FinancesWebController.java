package com.fd.mvc.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping("/modules/finance")
public class FinancesWebController {

	public static final String VIEW_FINANCE = "modules/finance/viewFinance";
	
	@GetMapping("/viewFinance")
	public String viewFinance(){
		return VIEW_FINANCE;
	}
	
}
