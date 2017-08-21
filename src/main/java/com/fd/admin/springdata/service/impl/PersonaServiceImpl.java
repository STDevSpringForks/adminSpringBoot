package com.fd.admin.springdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.admin.springdata.domain.Persona;
import com.fd.admin.springdata.repository.PersonaRepository;
import com.fd.admin.springdata.service.PersonaService;

/**
 * 
 * @author Muguruza
 *
 */
@Service("personaServiceImpl")
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public void save(Persona persona) {
		personaRepository.save(persona);
	}

	@Override
	public Iterable<Persona> findAll() {
		return personaRepository.findAll();
	}
	
	@Override
	public Persona findOne(int id) {
		return personaRepository.findOne(id);
	}

}
