package com.fd.adminHome.data_service.gastos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fd.adminHome.data_service.gastos.service.GastosService;
import com.fd.adminHome.model.gastos.criteria.GastosListDetailsSearchCriteria;
import com.fd.adminHome.model.gastos.entity.GastoEntity;
import com.fd.adminHome.model.gastos.result.GastosListDetailsResult;

/**
 * 
 * @author Muguruza
 *
 */
@RestController
@RequestMapping("")
public class GastosController {
	
	@Autowired
    @Qualifier("gastosServiceImpl")
    private GastosService gastosService;

    @RequestMapping(value = "/retrieveGastosListDetails", method = RequestMethod.POST)
    public GastosListDetailsResult retrieveGastosListDetails(@RequestBody GastosListDetailsSearchCriteria searchCriteria) {
        return gastosService.retrieveGastosListDetails(searchCriteria);
    }
    
    @RequestMapping(value = "/saveGastosListDetails", method = RequestMethod.POST)
    public boolean saveGastosListDetails(@RequestBody GastoEntity gEntity) {
        return gastosService.saveGastosListDetails(gEntity);
    }
	
}
