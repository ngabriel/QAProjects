package com.qa.week5project.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {
	
	//Create a connection with Connection Class imported from sql.Connection Dependency
	private Connection connection;
	
	
	//method to pass in 2 user and password into the created connection using Driver Manager.getConnection;
	// url can be hardcoded in
	public DatabaseConnection(String user, String password ) {
	
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ivm", user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//Instead of creating getters and setters for the connection, we can create methods to interact wiht connection
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Create a query method, Result set from database is returned and pass in string/sql statement to database

	public ResultSet sendQuery(String sql) throws SQLException {
		//To request a query we create a instance of statement object  from the createStatement method inside the connection class.
		Statement statement = connection.createStatement();
		//create the result set using the statement instance, we call the executeQuery method from statement clases and push in our sql String 
		ResultSet resultset = statement.executeQuery(sql);
		statement.close();
		return resultset;
	}
	
	//Create and update method, nothing is returned but we send a string to the database
	public void sendUpdate(String sql) throws SQLException
	{
		//Create a statement instance through Connection Class
		Statement statement = connection.createStatement();
		//use statement instances method executeUpdate to pass sql String to database to update with statement
		statement.executeUpdate(sql);
		statement.close();
		
	}
	
}
