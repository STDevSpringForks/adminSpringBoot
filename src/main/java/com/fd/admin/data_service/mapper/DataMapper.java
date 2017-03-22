package com.fd.admin.data_service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

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