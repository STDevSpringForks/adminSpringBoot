package com.fd.escuela.data_service.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.fd.escuela.data_service.service.EscuelaService;
import com.fd.escuela.model.Estudiante;

/**
 * 
 * @author Muguruza
 *
 */
@Service("escuelaServiceImpl")
public class EscuelaServiceImpl implements EscuelaService {

	@Override
	public Estudiante obtenerEstudiante() {
		
		ArrayList<Integer> scores = new ArrayList<>();
		scores.add(10);
		scores.add(9);
		scores.add(8);
		scores.add(7);
		
		Estudiante e = new Estudiante();
		System.out.println(e.getScores());
//		e.getScores().addAll(scores);
		e.setScores(scores);
		System.out.println(e.getScores());
		
		
		//Dos diferentes instancias del mismo objeto comparten sus valores estaticos, pero no 
		//sus valores no estaticos.
		Estudiante e1 = new Estudiante();
		System.out.println(e.ATRIBUTO_ESTATICO = "ESTATIC2");
		System.out.println(e1.ATRIBUTO_ESTATICO);
		
		
		return e;
	}
	
	
	public static void metodoEstatico(){
		//this. la referencia al actual objeto (this) no se puede utilizar en métodos estaticos.
	}

}
