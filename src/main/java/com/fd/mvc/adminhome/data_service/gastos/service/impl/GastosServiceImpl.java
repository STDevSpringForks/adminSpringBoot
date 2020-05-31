package com.fd.mvc.adminhome.data_service.gastos.service.impl;

import com.fd.mvc.adminhome.data_service.gastos.repository.GastosRepository;
import com.fd.mvc.adminhome.data_service.gastos.service.GastosService;
import com.fd.mvc.adminhome.model.gastos.criteria.GastosListDetailsSearchCriteria;
import com.fd.mvc.adminhome.model.gastos.entity.GastoEntity;
import com.fd.mvc.adminhome.model.gastos.result.GastosListDetailsResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Muguruza
 *
 */
@AllArgsConstructor
@Service("gastosServiceImpl")
public class GastosServiceImpl implements GastosService {

	private final GastosRepository gastosRepository;
	
	@Override
	public GastosListDetailsResult retrieveGastosListDetails(GastosListDetailsSearchCriteria searchCriteria) {
		return gastosRepository.retrieveGastosListDetails(searchCriteria);
	}

	@Override
	public boolean saveGastosListDetails(GastoEntity gEntity) {
		return gastosRepository.saveGastosListDetails(gEntity);
	}

}
