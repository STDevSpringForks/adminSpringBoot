package com.fd.admin.springdata.service;

import java.util.List;

import com.fd.admin.springdata.domain.UrlSocialNetwork;

/**
 * 
 * @author Muguruza
 *
 */
public interface UrlSocialNetworkService {
	public void save(UrlSocialNetwork tareas);
	public Iterable<UrlSocialNetwork> findAll();
	public List<UrlSocialNetwork> findByUrlSocialNetworkLike(String urlSocialNetwork);
	public Integer deleteByUrlSocialNetwork(String urlSocialNetwork);
}
