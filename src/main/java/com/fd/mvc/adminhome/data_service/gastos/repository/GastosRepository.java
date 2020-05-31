package com.fd.mvc.adminhome.data_service.gastos.repository;

import com.fd.mvc.adminhome.model.gastos.criteria.GastosListDetailsSearchCriteria;
import com.fd.mvc.adminhome.model.gastos.entity.GastoEntity;
import com.fd.mvc.adminhome.model.gastos.result.GastosListDetailsResult;

public interface GastosRepository {
	GastosListDetailsResult retrieveGastosListDetails(GastosListDetailsSearchCriteria searchCriteria);
	public boolean saveGastosListDetails(GastoEntity gEntity); 
}
