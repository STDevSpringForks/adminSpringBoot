package com.fd.criptocurrency.data_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.criptocurrency.data_service.repository.AddressCurrencyRepository;
import com.fd.criptocurrency.data_service.service.AddressCurrencyService;
import com.fd.criptocurrency.model.criteria.AddressCurrencySearchCriteria;
import com.fd.criptocurrency.model.entity.AddressCurrencyEntity;
import com.fd.criptocurrency.model.result.AddressCurrencySearchResult;

/**
 * 
 * @author Muguruza
 *
 */
@Service("addressCurrencyServiceImpl")
public class AddressCurrencyServiceImpl implements AddressCurrencyService {

	@Autowired
	private AddressCurrencyRepository addressCurrencyRepository;
	
	@Override
	public AddressCurrencySearchResult retriveAddressCurrency(AddressCurrencySearchCriteria sc) {
		return addressCurrencyRepository.retriveAddressCurrency(sc);
	}

	@Override
	public boolean saveAddressCurrency(AddressCurrencyEntity fEntity) {
		return addressCurrencyRepository.saveAddressCurrency(fEntity);
	}
	
	
}
