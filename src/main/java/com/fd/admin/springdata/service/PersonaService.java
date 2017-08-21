package com.fd.admin.springdata.service;

import com.fd.admin.springdata.domain.Persona;

/**
 * 
 * @author Muguruza
 *
 */
public interface PersonaService {
	public void save(Persona tareas);
	public Iterable<Persona> findAll();
	public Persona findOne(int id);
}
