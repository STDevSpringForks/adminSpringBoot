package com.fd.adminHome.data_service.gastos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.adminHome.data_service.gastos.repository.GastosRepository;
import com.fd.adminHome.data_service.gastos.service.GastosService;
import com.fd.adminHome.model.gastos.criteria.GastosListDetailsSearchCriteria;
import com.fd.adminHome.model.gastos.entity.GastoEntity;
import com.fd.adminHome.model.gastos.result.GastosListDetailsResult;

/**
 * 
 * @author Muguruza
 *
 */
@Service("gastosServiceImpl")
public class GastosServiceImpl implements GastosService {

	@Autowired
	private GastosRepository gastosRepository;
	
	@Override
	public GastosListDetailsResult retrieveGastosListDetails(GastosListDetailsSearchCriteria searchCriteria) {
		return gastosRepository.retrieveGastosListDetails(searchCriteria);
	}

	@Override
	public boolean saveGastosListDetails(GastoEntity gEntity) {
		return gastosRepository.saveGastosListDetails(gEntity);
	}

}
