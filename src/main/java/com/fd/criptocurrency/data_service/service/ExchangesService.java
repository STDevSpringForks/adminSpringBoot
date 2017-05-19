package com.fd.criptocurrency.data_service.service;

import com.fd.criptocurrency.model.criteria.ExchangesSearchCriteria;
import com.fd.criptocurrency.model.entity.ExchangeEntity;
import com.fd.criptocurrency.model.result.ExchangesSearchResult;

/**
 * 
 * @author Muguruza
 *
 */
public interface ExchangesService {
	public ExchangesSearchResult retriveExchanges(ExchangesSearchCriteria sc);
	public boolean saveExchange(ExchangeEntity eEntity);
}
