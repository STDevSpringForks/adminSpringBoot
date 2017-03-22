package com.fd.admin.model.result;

import java.io.Serializable;
import java.util.List;

import com.fd.admin.model.entity.PersonListDetailsEntity;

/**
 * 
 * @author Muguruza
 *
 */
public class PersonListDetailsResult implements Serializable {
	
	private static final long serialVersionUID = -7407165827329251651L;
	
	private List<PersonListDetailsEntity> personListDetailsEntity;

	public List<PersonListDetailsEntity> getPersonListDetailsEntity() {
		return personListDetailsEntity;
	}

	public void setPersonListDetailsEntity(List<PersonListDetailsEntity> personListDetailsEntity) {
		this.personListDetailsEntity = personListDetailsEntity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonListDetailsResult []");
		return builder.toString();
	}
	
}