package com.fd.admin.data_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.admin.data_service.repository.ObjectsRepository;
import com.fd.admin.data_service_api.ObjectsService;
import com.fd.admin.model.result.ObjectsResult;

@Service("objectsServiceImpl")
public class ObjectsServiceImpl implements ObjectsService {

	@Autowired
	private ObjectsRepository objectsRepository;
	
	@Override
	public ObjectsResult retrieveObjects() {
		return objectsRepository.retrieveObjects();
	}
	
}
