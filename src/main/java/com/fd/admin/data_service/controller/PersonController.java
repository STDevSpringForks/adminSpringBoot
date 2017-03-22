package com.fd.admin.data_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fd.admin.data_service_api.PersonService;
import com.fd.admin.model.criteria.PersonListDetailsSearchCriteria;
import com.fd.admin.model.entity.PersonListDetailsEntity;
import com.fd.admin.model.result.PersonListDetailsResult;

/**
 * 
 * @author Muguruza
 *
 */
@RestController
@RequestMapping("")
public class PersonController {
	
	@Autowired
    @Qualifier("personServiceImpl")
    private PersonService personService;

    @RequestMapping(value = "/retrievePersonListDetails", method = RequestMethod.POST)
    public PersonListDetailsResult retrievePersonListDetails(@RequestBody PersonListDetailsSearchCriteria searchCriteria) {
        return personService.retrievePersonListDetails(searchCriteria);
    }
    
    @RequestMapping(value = "/savePersonListDetails", method = RequestMethod.POST)
    public boolean savePersonListDetails(@RequestBody PersonListDetailsEntity searchCriteria) {
        return personService.savePersonListDetails(searchCriteria);
    }
	
}
