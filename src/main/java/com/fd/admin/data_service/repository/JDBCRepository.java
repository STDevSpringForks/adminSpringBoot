package com.fd.admin.data_service.repository;

import java.sql.Connection;

/**
 * 
 * @author Muguruza
 *
 */
public interface JDBCRepository {
	public Connection getConnectionJDBC();
}
