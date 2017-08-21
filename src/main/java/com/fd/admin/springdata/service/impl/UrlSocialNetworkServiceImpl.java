package com.fd.admin.springdata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public List<UrlSocialNetwork> findByUrlSocialNetworkLike(String urlSocialNetwork) {
		return urlSocialNetworkRepository.findByUrlSocialNetworkLike("%"+urlSocialNetwork+"%");
	}

	@Transactional
	@Override
	public Integer deleteByUrlSocialNetwork(String urlSocialNetwork) {
		
		/* Todo lo que este en éste método va hacer transactional. */
		
		return urlSocialNetworkRepository.deleteByUrlSocialNetwork(urlSocialNetwork);
	}
	
	
	
}
