package com.fd.adminHome.data_service.gastos.repository;

import com.fd.adminHome.model.gastos.criteria.GastosListDetailsSearchCriteria;
import com.fd.adminHome.model.gastos.result.GastosListDetailsResult;

/**
 * 
 * @author Muguruza
 *
 */
public interface GastosRepository {
	public GastosListDetailsResult retrieveGastosListDetails(GastosListDetailsSearchCriteria searchCriteria); 
}
