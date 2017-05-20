package com.fd.escuela.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fd.escuela.data_service.ifuncional.AreaTriangulo;
import com.fd.escuela.data_service.ifuncional.IEstudiante;
import com.fd.escuela.data_service.service.EscuelaService;
import com.fd.escuela.model.Estudiante;

/**
 * 
 * @author Muguruza
 *
 */
@Controller
@RequestMapping("/escuela")
public class EscuelaWebController {
	
	private static final String VIEW_ESTUDIANTE = "escuela/estudiante";
	
	@Autowired
	private EscuelaService escuelaService;

	/**
	 * 
	 * @return
	 */
    @GetMapping("/estudiante")
    public String placeAutocompleteAddressForm() {
//    	Estudiante estudiante = escuelaService.obtenerEstudiante();
    	
    	/* Métodos de referencia, solo funcionan con interfaces funcionales y estos métodos
    	 * de referencia no se le pasan parametros. */
    	IEstudiante ie = Estudiante::new;
    	Estudiante estudiante = ie.crear();
    	
        return VIEW_ESTUDIANTE;
    }
    
    /**
     * 
     * @return
     */
    @GetMapping("/areaTriangulo")
    public String areaTriangulo() {
    	BigDecimal base = new BigDecimal(5.2);
    	BigDecimal altura = new BigDecimal(10.1);
    	AreaTriangulo at = (x,y) -> (base.multiply(altura)).divide(new BigDecimal(2)); 
    	System.out.println(at.obtenerArea(base, altura));
    	return VIEW_ESTUDIANTE;
    }
	
}
