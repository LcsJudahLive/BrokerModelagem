package br.com.broker.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			return DriverManager.getConnection(
					"jdbc:mysql://localhost/broker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "123456");
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

}