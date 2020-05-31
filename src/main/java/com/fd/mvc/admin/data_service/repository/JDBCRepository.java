package com.fd.mvc.admin.data_service.repository;

import java.sql.Connection;

public interface JDBCRepository {
	Connection getConnectionJDBC();
}
