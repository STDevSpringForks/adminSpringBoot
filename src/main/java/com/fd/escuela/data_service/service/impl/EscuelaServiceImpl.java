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
		
		return e;
	}

}
