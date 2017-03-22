package com.fd.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fd.admin.data_service.validator.PersonValidator;
import com.fd.admin.data_service_api.PersonService;
import com.fd.admin.model.criteria.PersonListDetailsSearchCriteria;
import com.fd.admin.model.entity.PersonListDetailsEntity;
import com.fd.admin.model.result.PersonListDetailsResult;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping("/person")
public class PersonWebController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonWebController.class);
	private static final String VIEW_NEW_PERSON = "person/viewPerson";
	
	@Autowired
    PersonService personService;
    
    @Autowired
    PersonValidator personValidator;
	
	/**
     * Ingresar a la forma para enviar SMS
     * @param model
     * @return
     */
    @GetMapping("/viewPerson")
    public String formPayment(Model model) {
    	PersonListDetailsEntity personListDetailsEntity = new PersonListDetailsEntity();
        model.addAttribute("personListDetailsEntity", personListDetailsEntity);
        
        PersonListDetailsSearchCriteria searchCriteria = new PersonListDetailsSearchCriteria();
        PersonListDetailsResult personListDetailsResult = personService.retrievePersonListDetails(searchCriteria);
        model.addAttribute("personListDetailsResult", personListDetailsResult);
        
        return VIEW_NEW_PERSON;
    }
    
    /**
     * Enviar SMS
     * @param twilioSMSSearchCriteria
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/viewPerson")
    public String sendSMS(@ModelAttribute("personListDetailsEntity") PersonListDetailsEntity personListDetailsEntity, BindingResult result, Model model) {
        
        try {
        	personValidator.validate(personListDetailsEntity, result);
            if (result.hasErrors()) {
                return VIEW_NEW_PERSON;
            }
            
            boolean bResult = personService.savePersonListDetails(personListDetailsEntity);
            model.addAttribute("msgResult", bResult);

        } catch (Exception e) {
            LOGGER.debug("viewPerson Exception ", e);
            result.addError(new ObjectError("exception", e.getMessage()));
        }
        
        return VIEW_NEW_PERSON;
    }
	
}
