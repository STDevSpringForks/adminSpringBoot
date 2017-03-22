package com.fd.admin.data_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.admin.data_service.repository.PersonRepository;
import com.fd.admin.data_service_api.PersonService;
import com.fd.admin.model.criteria.PersonListDetailsSearchCriteria;
import com.fd.admin.model.entity.PersonListDetailsEntity;
import com.fd.admin.model.result.PersonListDetailsResult;

/**
 * 
 * @author Muguruza
 *
 */
@Service("personServiceImpl")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public PersonListDetailsResult retrievePersonListDetails(PersonListDetailsSearchCriteria searchCriteria) {
		return personRepository.retrievePersonListDetails(searchCriteria);
	}

	@Override
	public boolean savePersonListDetails(PersonListDetailsEntity personListDetailsEntity) {
		return personRepository.savePersonListDetails(personListDetailsEntity);
	}

}
