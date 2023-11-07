package com.Ejercicios_Clase13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;



import java.sql.SQLData;

public class App 
{
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/qatar2022";
	
	public static final String user = "root";
	public static final String password = "juan";
	
    public static void main( String[] args )
    {	
    	
    	Connection connection=null;
    	Statement statement=null;
    	PreparedStatement pStatement;
    	    	
    	//Lee tabla empleado
    	try {
    		connection = DriverManager.getConnection(DB_URL, user, password);    		
    		statement = connection.createStatement();    		
    		ResultSet querry = statement.executeQuery("SELECT * FROM empleado");    		
    		String base="";    		
    		while (querry.next())
    		{
    			base += querry.getString("nombre")+" "+querry.getString("apellido")+" "+querry.getString("nacionalidad")+" "+querry.getString("dni")+"\n";    			
    		}    		
    		System.out.println(base);
    		querry.close();    		
    		connection.close();    		
    	}
    	catch(SQLException e) {System.out.println( "SELECT FROM: Failed" );}    
    	
    	
    	//Agrega campos a la tabla empleado
    	try {
    		String campo = "INSERT INTO empleado\nVALUES ('3', 'Albert', 'Einstein', 'Aleman', '132435', '11');";
    		connection = DriverManager.getConnection(DB_URL, user, password);    		
    		pStatement = connection.prepareStatement(campo);    		
    		pStatement.executeUpdate();    		
    		pStatement.close();    		
    		connection.close();
    	}
    	catch(SQLException e) {System.out.println( "INSERT: Failed" );} 
    	
    	
    	//Actualiza nombre empleado
    	try {
    		String campo = "UPDATE empleado SET nombre = 'Juan Manuel' WHERE nombre = 'Juan'";
    		connection = DriverManager.getConnection(DB_URL, user, password);    		
    		pStatement = connection.prepareStatement(campo);    		
    		pStatement.executeUpdate();    		
    		pStatement.close();    		
    		connection.close();
    	}
    	catch(SQLException e) {System.out.println( "UPDATE: Failed" );} 
    	    	
    	
    	//Borra campo de la tabla de empleado
    	try {
    		connection = DriverManager.getConnection(DB_URL, user, password);    		
    		pStatement = connection.prepareStatement("DELETE FROM empleado WHERE nombre='Juan Manuel'");    		
    		pStatement.executeUpdate();    		
    		pStatement.close();    		
    		connection.close();
    	}
    	catch(SQLException e) {System.out.println( "DELETE: Failed" );}     	
    }
}
