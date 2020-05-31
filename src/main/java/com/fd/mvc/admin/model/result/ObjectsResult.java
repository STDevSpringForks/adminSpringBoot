package com.fd.mvc.admin.model.result;

import com.fd.mvc.admin.model.entity.ObjectsEntity;

import java.io.Serializable;
import java.util.List;

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
