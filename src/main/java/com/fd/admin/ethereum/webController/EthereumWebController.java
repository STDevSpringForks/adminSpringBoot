package com.fd.admin.ethereum.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fd.admin.ethereum.data_service.service.EthereumService;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping(value = "/ethereum")
public class EthereumWebController {

	@Autowired
	@Qualifier("ethereumServiceImpl")
	private EthereumService ethereumService;
	
	public final String VIEW_ETHEREUM = "ethereum/viewEthereum";
	
	@GetMapping(value = "/viewEthereum")
	public String ethereumWeb3jTest(){
		
		ethereumService.ethereumWeb3jTest();
		
		return VIEW_ETHEREUM;
	}
	
}
