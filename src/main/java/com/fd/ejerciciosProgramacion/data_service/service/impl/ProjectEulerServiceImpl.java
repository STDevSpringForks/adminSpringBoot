package com.fd.ejerciciosProgramacion.data_service.service.impl;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.fd.ejerciciosProgramacion.data_service.service.ProjectEulerService;

/**
 * 
 * @author Muguruza
 *
 */
@Service("projectEulerServiceImpl")
public class ProjectEulerServiceImpl implements ProjectEulerService {

	@Override
	public long sumaDeMultiplos(int limiteDeSerie,List<Integer> multiplosDe) {
		int suma = 0;
		IntPredicate predicate  = s -> (s%multiplosDe.get(0)==0 || s%multiplosDe.get(1)==0);
		if(limiteDeSerie >= 0 && multiplosDe.size() > 0){
			suma = IntStream.range(3, 1000).filter(predicate).sum();
		}
		return suma;
	}
}