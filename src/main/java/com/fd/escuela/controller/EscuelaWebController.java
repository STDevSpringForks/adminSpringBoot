package com.fd.escuela.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    	Estudiante estudiante = escuelaService.obtenerEstudiante();
        return VIEW_ESTUDIANTE;
    }
	
}
