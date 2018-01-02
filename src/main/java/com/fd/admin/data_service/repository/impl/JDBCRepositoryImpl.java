package com.fd.admin.data_service.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fd.admin.data_service.repository.JDBCRepository;

/**
 * 
 * @author Muguruza
 *
 */
@Repository
public class JDBCRepositoryImpl implements JDBCRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(JDBCRepositoryImpl.class);

	public Connection getConnectionJDBC() {

		Connection myConn = null;
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate_adminSpringMVC?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pass = "abc123";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			LOGGER.info("Connecting to database " , jdbcUrl);
			myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			LOGGER.info("Connection successful!!" , myConn);
		} catch (Exception exc) {
			LOGGER.debug("Error in connection JDBC ", exc);
		}

		return myConn;

	}

}
