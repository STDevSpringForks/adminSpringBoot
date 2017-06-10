package com.fd.admin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fd.ejerciciosProgramacion.data_service.service.ProjectEulerService;



/**
 * https://projecteuler.ne
 * @author Muguruza
 *
 */
@Controller
@RequestMapping(value = "/ejerciciosProgramacion")
public class EjerciciosProgramacionWebController {

    private static final String VIEW_EJERCICIOS = "ejerciciosProgramacion/viewEjercicios";
    
    @Autowired
    @Qualifier("projectEulerServiceImpl")
    private ProjectEulerService projectEulerService;
    
    /**
     * 
     * @param model
     * @return
     */
    @GetMapping("/viewEjercicios")
    public String viewBitso(Model model) {
        
    	List<Integer> multiplosDe = Arrays.asList(3,5);
    	long sumaDeMultiplos = projectEulerService.sumaDeMultiplos(1000,multiplosDe);
    	System.out.println(sumaDeMultiplos);
    	
    	long sumaFibonacci = projectEulerService.sumaFibonacci(4_000_000);
    	System.out.println(sumaFibonacci);
    	
        return VIEW_EJERCICIOS;
    }
    
}