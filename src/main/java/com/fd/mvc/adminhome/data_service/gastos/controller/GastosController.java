package com.fd.mvc.adminhome.data_service.gastos.controller;

import com.fd.mvc.adminhome.data_service.gastos.service.GastosService;
import com.fd.mvc.adminhome.model.gastos.criteria.GastosListDetailsSearchCriteria;
import com.fd.mvc.adminhome.model.gastos.entity.GastoEntity;
import com.fd.mvc.adminhome.model.gastos.result.GastosListDetailsResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("")
public class GastosController {
	
    private final GastosService gastosService;

    @RequestMapping(value = "/retrieveGastosListDetails", method = RequestMethod.POST)
    public GastosListDetailsResult retrieveGastosListDetails(@RequestBody GastosListDetailsSearchCriteria searchCriteria) {
        return gastosService.retrieveGastosListDetails(searchCriteria);
    }
    
    @RequestMapping(value = "/saveGastosListDetails", method = RequestMethod.POST)
    public boolean saveGastosListDetails(@RequestBody GastoEntity gEntity) {
        return gastosService.saveGastosListDetails(gEntity);
    }
	
}
