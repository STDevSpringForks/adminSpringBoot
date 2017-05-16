package com.fd.criptocurrency.data_service.service;

import com.fd.criptocurrency.model.criteria.AddressCurrencySearchCriteria;
import com.fd.criptocurrency.model.entity.AddressCurrencyEntity;
import com.fd.criptocurrency.model.result.AddressCurrencySearchResult;

/**
 * 
 * @author Muguruza
 *
 */
public interface AddressCurrencyService {
	public AddressCurrencySearchResult retriveAddressCurrency(AddressCurrencySearchCriteria sc);
	public boolean saveAddressCurrency(AddressCurrencyEntity fEntity);
}
