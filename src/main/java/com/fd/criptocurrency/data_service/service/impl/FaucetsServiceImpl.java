package com.fd.criptocurrency.data_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.criptocurrency.data_service.repository.FaucetsRepository;
import com.fd.criptocurrency.data_service.service.FaucetsService;
import com.fd.criptocurrency.model.criteria.FaucetsSearchCriteria;
import com.fd.criptocurrency.model.entity.FaucetEntity;
import com.fd.criptocurrency.model.result.FaucetsSearchResult;

/**
 * 
 * @author Muguruza
 *
 */
@Service("faucetsServiceImpl")
public class FaucetsServiceImpl implements FaucetsService {

	@Autowired
	private FaucetsRepository faucetsRepository;
	
	@Override
	public FaucetsSearchResult retriveFaucets(FaucetsSearchCriteria sc) {
		return faucetsRepository.retriveFaucets(sc);
	}

	@Override
	public boolean saveFaucet(FaucetEntity fEntity) {
		return faucetsRepository.saveFaucet(fEntity);
	}

}
