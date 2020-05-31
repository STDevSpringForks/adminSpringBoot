package com.fd.mvc.repository.impl;

import com.fd.mvc.repository.JDBCRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
@Repository
public class JDBCRepositoryImpl implements JDBCRepository {

	public Connection getConnectionJDBC() {

		Connection myConn = null;
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate_adminSpringMVC?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pass = "abc123";

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
