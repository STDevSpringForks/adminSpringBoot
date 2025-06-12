package com.fd.mvc.service.impl;

import com.fd.mvc.model.ObjectsResult;
import com.fd.mvc.repository.ObjectsRepository;
import com.fd.mvc.service.ObjectsService;
import org.springframework.stereotype.Service;

@Service("objectsService")
public class ObjectsServiceImpl implements ObjectsService {

    private final ObjectsRepository objectsRepository;

    public ObjectsServiceImpl(ObjectsRepository objectsRepository) {
        this.objectsRepository = objectsRepository;
    }

    @Override
    public ObjectsResult retrieveObjects() {
        return objectsRepository.retrieveObjects();
    }

}
