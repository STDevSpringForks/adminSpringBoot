package com.fd.mvc.mapper;

import com.fd.mvc.model.ModelPojo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelPojoMapper extends DataMapper<ModelPojo> {

	@Override
	public ModelPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		ModelPojo modelPojo = new ModelPojo();
		modelPojo.setTest1(rs.getString("column_1"));
		modelPojo.setTest2(rs.getString("column_2"));
		return modelPojo;
	}

}
