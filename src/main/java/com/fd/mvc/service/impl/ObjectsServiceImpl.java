package com.fd.mvc.service.impl;

import com.fd.mvc.model.ObjectsResult;
import com.fd.mvc.repository.ObjectsRepository;
import com.fd.mvc.service.ObjectsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("objectsService")
public class ObjectsServiceImpl implements ObjectsService {

    private final ObjectsRepository objectsRepository;

    @Override
    public ObjectsResult retrieveObjects() {
        return objectsRepository.retrieveObjects();
    }

}
