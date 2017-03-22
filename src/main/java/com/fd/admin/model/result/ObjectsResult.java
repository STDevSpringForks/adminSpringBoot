package com.fd.admin.model.result;

import java.io.Serializable;
import java.util.List;

import com.fd.admin.model.entity.ObjectsEntity;

/**
 * 
 * @author Muguruza
 *
 */
public class ObjectsResult implements Serializable {
	
	private static final long serialVersionUID = 1819347632814394839L;
	
	private List<ObjectsEntity> objectsEntity;

	public List<ObjectsEntity> getObjectsEntity() {
		return objectsEntity;
	}

	public void setObjectsEntity(List<ObjectsEntity> objectsEntity) {
		this.objectsEntity = objectsEntity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ObjectsResult [objectsEntity=");
		builder.append(objectsEntity);
		builder.append("]");
		return builder.toString();
	}
	
}