package com.adel.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMySQL {

	   private static String name = "adel";
	    private static String password = "adel156651";
	    private static String jdbc = "jdbc:mysql://localhost/rooms";
	    private static String driver = "com.mysql.jdbc.Driver";
	    
	    // DataBase Connection
	    public static Connection getConnection() throws SQLException {
	    	
	    	try {
	    		  Class.forName(driver);
	    		  
	    	}catch (Exception e) {
	    		e.printStackTrace();
			}
	    	
	    	return DriverManager.getConnection(jdbc , name , password);
	    }
}
