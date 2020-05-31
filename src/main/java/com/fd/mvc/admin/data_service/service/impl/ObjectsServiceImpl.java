package com.fd.mvc.admin.data_service.service.impl;

import com.fd.mvc.admin.data_service.repository.ObjectsRepository;
import com.fd.mvc.admin.data_service_api.ObjectsService;
import com.fd.mvc.admin.model.result.ObjectsResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("objectsServiceImpl")
public class ObjectsServiceImpl implements ObjectsService {

	private final ObjectsRepository objectsRepository;
	
	@Override
	public ObjectsResult retrieveObjects() {
		return objectsRepository.retrieveObjects();
	}
	
}
