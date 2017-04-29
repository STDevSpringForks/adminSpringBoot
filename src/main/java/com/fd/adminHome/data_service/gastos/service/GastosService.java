package com.fd.adminHome.data_service.gastos.service;

import com.fd.adminHome.model.gastos.criteria.GastosListDetailsSearchCriteria;
import com.fd.adminHome.model.gastos.entity.GastoEntity;
import com.fd.adminHome.model.gastos.result.GastosListDetailsResult;

/**
 * 
 * @author Muguruza
 *
 */
public interface GastosService {
	GastosListDetailsResult retrieveGastosListDetails(GastosListDetailsSearchCriteria searchCriteria);
	boolean saveGastosListDetails(GastoEntity entity);
}
