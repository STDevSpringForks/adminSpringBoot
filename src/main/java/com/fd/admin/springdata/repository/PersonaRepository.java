package com.fd.admin.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.fd.admin.springdata.domain.Persona;

/**
 * 
 * @author Muguruza
 *
 */
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

}
