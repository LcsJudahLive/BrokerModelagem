package br.com.broker.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import com.mysql.jdbc.Driver;
import javax.management.RuntimeErrorException;

public class ConnectionFactory {
	public Connection getConnection(){
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/broker","root","------");			
		}catch (SQLException e){
			throw new RuntimeException(e);
			
		}
	}
	
	
}
