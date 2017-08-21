package com.fd.admin.springdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.admin.springdata.domain.UrlSocialNetwork;
import com.fd.admin.springdata.repository.UrlSocialNetworkRepository;
import com.fd.admin.springdata.service.UrlSocialNetworkService;

/**
 * 
 * @author Muguruza
 *
 */
@Service("urlSocialNetworkServiceImpl")
public class UrlSocialNetworkServiceImpl implements UrlSocialNetworkService {
	
	@Autowired
	private UrlSocialNetworkRepository urlSocialNetworkRepository;

	@Override
	public void save(UrlSocialNetwork urlSocialNetwork) {
		urlSocialNetworkRepository.save(urlSocialNetwork);
	}

	@Override
	public Iterable<UrlSocialNetwork> findAll() {
		return urlSocialNetworkRepository.findAll();
	}
	
}
