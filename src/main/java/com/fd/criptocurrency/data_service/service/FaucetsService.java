package com.fd.criptocurrency.data_service.service;

import com.fd.criptocurrency.model.criteria.FaucetsSearchCriteria;
import com.fd.criptocurrency.model.entity.FaucetEntity;
import com.fd.criptocurrency.model.result.FaucetsSearchResult;

/**
 * 
 * @author Muguruza
 *
 */
public interface FaucetsService {
	public FaucetsSearchResult retriveFaucets(FaucetsSearchCriteria sc);
	public boolean saveFaucet(FaucetEntity fEntity);
}
