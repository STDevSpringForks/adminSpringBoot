package com.fd.mvc.admin.data_service.mapper;

import com.fd.mvc.admin.model.ModelPojo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Muguruza
 *
 */
public class ModelPojoMapper extends DataMapper<ModelPojo> {

	@Override
	public ModelPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		ModelPojo modelPojo = new ModelPojo();
		modelPojo.setTest1(rs.getString("column_1"));
		modelPojo.setTest2(rs.getString("column_2"));
		return modelPojo;
	}

}
