package com.fd.mvc.model;

import com.fd.mvc.model.entity.ObjectsEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ObjectsResult implements Serializable {
	
	private static final long serialVersionUID = 1819347632814394839L;
	
	private List<ObjectsEntity> objectsEntity;

}
