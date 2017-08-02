package com.fd.admin.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.fd.admin.springdata.domain.Tareas;

/**
 * 
 * @author Muguruza
 *
 */
public interface TareasRepository extends CrudRepository<Tareas, Integer> {
	//NO SE NECESITA IMPLEMENTAR LOS MÉTODOS CRUD.
	
	/*
	 * Ya se puede utilizar los métodos:
	 * -save
	 * -findOne
	 * -exists
	 * -findAll
	 * -count
	 * -delete
	 */
	
}
