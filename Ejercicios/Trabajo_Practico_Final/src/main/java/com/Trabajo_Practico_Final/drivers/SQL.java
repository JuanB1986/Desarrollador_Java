package com.Trabajo_Practico_Final.drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class SQL {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static Statement statement;
	private static ResultSet resultSet;
	
	public SQL() {}
	
	//Conexion a base de datos
	public static boolean Connect(String url, String user, String password) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			return !connection.isClosed();
		}
		catch(SQLException e) {return false;}
	}
	
	
	//Consulta con SELECT * FROM
	public static String Read(String consulta, String columnas) {		
		String split[] = columnas.split(",");
		String retVal=""; 		
	   	try {    			
    		statement = connection.createStatement();    		
    		resultSet = statement.executeQuery(consulta); 
    		
    		while (resultSet.next()) {
    			for (int i=0; i<split.length;++i) {
    				retVal += resultSet.getString(split[i].strip())+", ";
    			}
    			retVal += "\n";
    		}
    		return retVal;
    	}
    	catch(SQLException e) {return "SQLRead_Exception";} 		
	}
	
	
	//Consultas: INSERT, UPDATE
	public static boolean Querry(String querry) {
		try {			
 			preparedStatement = connection.prepareStatement(querry);    		
			preparedStatement.executeUpdate();   
			return true;
		}
		catch(SQLException e) {return false;} 
	}
		
	//Cierra conexión
	public static boolean Close() {
		try {
			statement.close();
			preparedStatement.close();
			connection.close();
			return connection.isClosed();
		}
		catch(SQLException e) {return false;}
		catch(NullPointerException n) {return false;}
	}
}
