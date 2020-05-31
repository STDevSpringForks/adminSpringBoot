package com.fd.mvc.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DataMapper<T> implements RowMapper<T> {
	@Override
	public abstract T mapRow(ResultSet rs, int rowNum) throws SQLException;
}
