package com.fd.admin.data_service.repository;

import com.fd.admin.model.criteria.PersonListDetailsSearchCriteria;
import com.fd.admin.model.entity.PersonListDetailsEntity;
import com.fd.admin.model.result.PersonListDetailsResult;

/**
 * 
 * @author Muguruza
 *
 */
public interface PersonRepository {
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
	boolean savePersonListDetails(PersonListDetailsEntity personListDetailsEntity);
}
