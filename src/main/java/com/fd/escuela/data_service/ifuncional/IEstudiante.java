package com.fd.escuela.data_service.ifuncional;

import com.fd.escuela.model.Estudiante;

/**
 * 
 * @author Muguruza
 *
 */
@FunctionalInterface
public interface IEstudiante {
	public Estudiante crear();
}
