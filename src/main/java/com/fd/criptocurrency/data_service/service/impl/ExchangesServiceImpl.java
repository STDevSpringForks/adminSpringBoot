package com.fd.criptocurrency.data_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.criptocurrency.data_service.repository.ExchangesRepository;
import com.fd.criptocurrency.data_service.service.ExchangesService;
import com.fd.criptocurrency.model.criteria.ExchangesSearchCriteria;
import com.fd.criptocurrency.model.entity.ExchangeEntity;
import com.fd.criptocurrency.model.result.ExchangesSearchResult;

/**
 * 
 * @author Muguruza
 *
 */
@Service("exchangesServiceImpl")
public class ExchangesServiceImpl implements ExchangesService {

	@Autowired
	private ExchangesRepository exchangesRepository;
	
	@Override
	public ExchangesSearchResult retriveExchanges(ExchangesSearchCriteria sc) {
		return exchangesRepository.retriveExchanges(sc);
	}

	@Override
	public boolean saveExchange(ExchangeEntity eEntity) {
		return exchangesRepository.saveExchange(eEntity);
	}

}
