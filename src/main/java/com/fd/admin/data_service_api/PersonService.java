package com.fd.admin.data_service_api;

import com.fd.admin.model.criteria.PersonListDetailsSearchCriteria;
import com.fd.admin.model.entity.Person;
import com.fd.admin.model.result.PersonListDetailsResult;

/**
 * 
 * @author Muguruza
 *
 */
public interface PersonService {
	/**
	 * 
	 * @param searchCriteria
	 * @return
	 */
	PersonListDetailsResult retrievePersonListDetails(PersonListDetailsSearchCriteria searchCriteria);
	
	/**
	 * 
	 * @param personListDetailsEntity
	 * @return
	 */
	boolean savePersonListDetails(Person personListDetailsEntity);
}
