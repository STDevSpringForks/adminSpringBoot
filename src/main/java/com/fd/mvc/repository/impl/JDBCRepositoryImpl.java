package com.fd.mvc.repository.impl;

import com.fd.mvc.repository.JDBCRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

@Repository
public class JDBCRepositoryImpl implements JDBCRepository {

        private static final Logger log = LoggerFactory.getLogger(JDBCRepositoryImpl.class);

	public Connection getConnectionJDBC() {

		Connection myConn = null;
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate_adminSpringMVC?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pass = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			log.info("Connecting to database " , jdbcUrl);
			myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			log.info("Connection successful!!" , myConn);
		} catch (Exception exc) {
			log.debug("Error in connection JDBC ", exc);
		}

		return myConn;

	}

}
