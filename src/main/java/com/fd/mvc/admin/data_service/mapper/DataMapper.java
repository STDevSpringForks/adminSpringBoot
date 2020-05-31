package com.fd.mvc.admin.data_service.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Muguruza
 *
 * @param <T>
 */
public abstract class DataMapper<T> implements RowMapper<T> {
	@Override
	public abstract T mapRow(ResultSet rs, int rowNum) throws SQLException;
}
