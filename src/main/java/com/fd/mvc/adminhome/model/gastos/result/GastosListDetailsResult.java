package com.fd.mvc.adminhome.model.gastos.result;

import com.fd.mvc.adminhome.model.gastos.entity.GastoEntity;

import java.io.Serializable;
import java.util.List;

public class GastosListDetailsResult implements Serializable {
	
	private static final long serialVersionUID = -19168050722916427L;

	private List<GastoEntity> gastosListDetailsEntity;

	public List<GastoEntity> getGastosListDetailsEntity() {
		return gastosListDetailsEntity;
	}

	public void setGastosListDetailsEntity(List<GastoEntity> gastosListDetailsEntity) {
		this.gastosListDetailsEntity = gastosListDetailsEntity;
	}

}
