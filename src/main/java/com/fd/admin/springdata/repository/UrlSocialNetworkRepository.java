package com.fd.admin.springdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fd.admin.springdata.domain.UrlSocialNetwork;

/**
 * 
 * @author Muguruza
 *
 */
public interface UrlSocialNetworkRepository extends CrudRepository<UrlSocialNetwork, Integer> {
	/*
	 * [[[[[[[[[[NO SE NECESITA IMPLEMENTAR LOS MÉTODOS CRUD]]]]]]]]]]
	 * Ya se puede utilizar los métodos:
	 * -save
	 * -findOne
	 * -exists
	 * -findAll
	 * -count
	 * -delete
	 */
}
