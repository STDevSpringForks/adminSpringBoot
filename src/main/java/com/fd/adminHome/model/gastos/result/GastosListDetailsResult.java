package com.fd.adminHome.model.gastos.result;

import java.io.Serializable;
import java.util.List;

import com.fd.adminHome.model.gastos.entity.GastoEntity;

/**
 * 
 * @author Muguruza
 *
 */
public class GastosListDetailsResult implements Serializable {
	
	private static final long serialVersionUID = -19168050722916427L;
	
	private List<GastoEntity> gastosListDetailsEntity;

	public List<GastoEntity> getGastosListDetailsEntity() {
		return gastosListDetailsEntity;
	}

	public void setGastosListDetailsEntity(List<GastoEntity> gastosListDetailsEntity) {
		this.gastosListDetailsEntity = gastosListDetailsEntity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GastosListDetailsResult [gastosListDetailsEntity=");
		builder.append(gastosListDetailsEntity);
		builder.append("]");
		return builder.toString();
	}
	
}