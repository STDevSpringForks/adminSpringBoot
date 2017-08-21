package com.fd.admin.springdata.service;

import com.fd.admin.springdata.domain.UrlSocialNetwork;

/**
 * 
 * @author Muguruza
 *
 */
public interface UrlSocialNetworkService {
	public void save(UrlSocialNetwork tareas);
	public Iterable<UrlSocialNetwork> findAll();
}
