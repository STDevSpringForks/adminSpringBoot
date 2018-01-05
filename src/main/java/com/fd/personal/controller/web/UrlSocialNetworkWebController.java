package com.fd.personal.controller.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fd.admin.springdata.domain.Persona;
import com.fd.admin.springdata.domain.UrlSocialNetwork;
import com.fd.admin.springdata.service.PersonaService;
import com.fd.admin.springdata.service.UrlSocialNetworkService;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping(value = "/personal/socialNetwork")
public class UrlSocialNetworkWebController {

	private static final String VIEW_SOCIAL_NETWORK = "personal/socialNetwork/viewSocialNetwork";
	
	@Autowired
	@Qualifier("urlSocialNetworkServiceImpl")
	private UrlSocialNetworkService urlSocialNetworkService;
	
	@Autowired
	@Qualifier("personaServiceImpl")
	private PersonaService personaService;
	
	@RequestMapping(value = "/viewSocialNetwork",method = RequestMethod.GET)
	public String java8Testing(){
		
		System.out.println("--------------------->>>>");
		
		Persona persona = personaService.findOne(6);
		System.out.println("Persona : " + persona.toString());
				
		
		UrlSocialNetwork urlSocialNetwork = new UrlSocialNetwork();
		urlSocialNetwork.setUrlSocialNetwork("www.facebook.com/ff897987");
		urlSocialNetwork.setPersona(persona);
		urlSocialNetworkService.save(urlSocialNetwork);
		
		System.out.println("--------------------->>>>");
    	
    	System.out.println(urlSocialNetworkService.findAll());
    	List<UrlSocialNetwork> urlSocialNetworkList = urlSocialNetworkService.findByUrlSocialNetworkLike("facebook");
    	
    	System.out.println("--------------------->>>>");
    	
    	int index = 1;
    	Page<UrlSocialNetwork> page = urlSocialNetworkService.findAll(index - 1);
    	
    	//page.getContent() //Obtienes la lista de la página 1.
    	//page.getTotalPages() //Numero de paginas que se crearon.
    	
    	//Solo se cambia el numero de index para ir obteniendo la lista de diferente pagina.
    	
		return VIEW_SOCIAL_NETWORK;
	}
	
}
