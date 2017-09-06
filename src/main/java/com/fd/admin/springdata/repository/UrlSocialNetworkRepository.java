package com.fd.admin.springdata.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.fd.admin.springdata.domain.Persona;
import com.fd.admin.springdata.domain.UrlSocialNetwork;

/**
 * JPQL
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
	
	/**
	 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	 * Example 5. Derived Count Query  ---- revisar la nomenclatura
	 * Spring Data: SELECT * FROM urlsocialnetwork WHERE UrlSocialNetwork LIKE ...
	 * @param urlSocialNetwork
	 * @return
	 */
	public List<UrlSocialNetwork> findByUrlSocialNetworkLike(String urlSocialNetwork);
	//public List<UrlSocialNetwork> findByFechaTramiteLessThan(Timestamp urlSocialNetwork);
	public Integer deleteByUrlSocialNetwork(String urlSocialNetwork);
	public List<UrlSocialNetwork> findByPersona(Persona persona);
	public Page<UrlSocialNetwork> findAll(Pageable pageable);
	
}
