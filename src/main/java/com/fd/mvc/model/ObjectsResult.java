package com.fd.mvc.model;

import com.fd.mvc.model.entity.ObjectsEntity;

import java.io.Serializable;
import java.util.List;

public class ObjectsResult implements Serializable {
	
	private static final long serialVersionUID = 1819347632814394839L;
	
	private List<ObjectsEntity> objectsEntity;

    public List<ObjectsEntity> getObjectsEntity() {
        return objectsEntity;
    }

    public void setObjectsEntity(List<ObjectsEntity> objectsEntity) {
        this.objectsEntity = objectsEntity;
    }

}
