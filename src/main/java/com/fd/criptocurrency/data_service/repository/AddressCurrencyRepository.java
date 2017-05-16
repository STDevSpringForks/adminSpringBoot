package com.fd.criptocurrency.data_service.repository;

import com.fd.criptocurrency.model.criteria.AddressCurrencySearchCriteria;
import com.fd.criptocurrency.model.entity.AddressCurrencyEntity;
import com.fd.criptocurrency.model.result.AddressCurrencySearchResult;

/**
 * 
 * @author Muguruza
 *
 */
public interface AddressCurrencyRepository {
	public AddressCurrencySearchResult retriveAddressCurrency(AddressCurrencySearchCriteria sc);
	public boolean saveAddressCurrency(AddressCurrencyEntity fEntity);	
}
