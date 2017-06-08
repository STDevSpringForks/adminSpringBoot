package com.fd.ejerciciosProgramacion.data_service.service;

import java.util.List;

/**
 * 
 * @author Muguruza
 *
 */
public interface ProjectEulerService {
	
	/**
	 * Obteger la suma de todos los multiplos del array @param multiplosDe
	 * que esten por debajo del numero limiteDeSerie.
	 * @param limiteDeSerie
	 * @param multiplosDe
	 * @return
	 */
	public long sumaDeMultiplos(int limiteDeSerie,List<Integer> multiplosDe);
}
