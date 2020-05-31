package com.fd.mvc.adminhome.data_service.gastos.service;

import com.fd.mvc.adminhome.model.gastos.criteria.GastosListDetailsSearchCriteria;
import com.fd.mvc.adminhome.model.gastos.entity.GastoEntity;
import com.fd.mvc.adminhome.model.gastos.result.GastosListDetailsResult;

public interface GastosService {
	GastosListDetailsResult retrieveGastosListDetails(GastosListDetailsSearchCriteria searchCriteria);
	boolean saveGastosListDetails(GastoEntity entity);
}
