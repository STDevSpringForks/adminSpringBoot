package com.fd.mvc.admin.controller;

import com.fd.mvc.adminhome.model.gastos.FormAddAddressCurrencyCriteria;
import com.fd.mvc.adminhome.model.gastos.FormAddExchangeCriteria;
import com.fd.mvc.adminhome.model.gastos.FormAddFaucetCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping(value = "/criptoCurrency")
public class CriptoCurrencyWebController {

	public static final String VIEW_CRIPTOCURRENCY = "mainCripto";
	
	@GetMapping("/retriveAddressCurrency")
	public String retriveAddressCurrency() {
		return VIEW_CRIPTOCURRENCY;
	}
	@PostMapping(value = "/saveAddressCurrency")
	public String saveAddressCurrency(@ModelAttribute FormAddAddressCurrencyCriteria criteria, RedirectAttributes redirectAttributes) {
		return VIEW_CRIPTOCURRENCY;
	}
	
	@GetMapping("/retriveExchanges")
	public String retriveExchanges() {
		return VIEW_CRIPTOCURRENCY;
	}
	@PostMapping(value = "/saveExchange")
	public String saveExchange(@ModelAttribute FormAddExchangeCriteria criteria,RedirectAttributes redirectAttributes) {
		return VIEW_CRIPTOCURRENCY;
	}
	
	@GetMapping("/retriveFaucets")
	public String retriveFaucets() {
		return VIEW_CRIPTOCURRENCY;
	}
	
	@PostMapping(value = "/saveFaucet")
	public String saveFaucet(@ModelAttribute FormAddFaucetCriteria criteria,RedirectAttributes redirectAttributes) {
		return VIEW_CRIPTOCURRENCY;
	}
	
}
