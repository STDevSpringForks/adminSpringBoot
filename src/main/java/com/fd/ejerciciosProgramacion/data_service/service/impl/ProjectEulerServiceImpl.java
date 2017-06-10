package com.fd.ejerciciosProgramacion.data_service.service.impl;

import java.util.ArrayList;
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
		if(limiteDeSerie >= 0 && multiplosDe.size() > 0){
			IntPredicate predicate  = s -> multiplosDe.stream().anyMatch(i -> s % i == 0);
			suma = IntStream.range(3, limiteDeSerie).filter(predicate).sum();
		}
		return suma;
	}

	@Override
	public long sumaFibonacci(long limiteDeSerie) {
		long suma = 0;
		
		List<Long> listaNumeros = new ArrayList<>();
		listaNumeros.add(1L);
		listaNumeros.add(2L);
		int posicion = 0;
        long sumaTotal = 0L;
		
		do{
          suma = listaNumeros.get(posicion) + listaNumeros.get(++posicion);
          if(suma < limiteDeSerie){
            listaNumeros.add(suma);
          }
		  sumaTotal = listaNumeros.stream().filter(s -> (s % 2) == 0).mapToLong(Long::new).sum();
		}
		while(suma < limiteDeSerie);
    
		return sumaTotal;
	}
}