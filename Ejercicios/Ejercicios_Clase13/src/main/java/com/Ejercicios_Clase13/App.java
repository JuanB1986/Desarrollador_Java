package com.Ejercicios_Clase13;

public class App 
{
	//public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/qatar2022";	
	public static final String user = "root";
	public static final String password = "juan";
	
    public static void main( String[] args )
    {	
    	
    	SQL objSQL=new SQL();
    	
    	//Inicio conexion
    	if (objSQL.SQLConnect(DB_URL, user, password))
    	{    		   	    	
	    	//Agrega campos: Si ya existen los campos, ejecuta la excepcion dentro de SQLQuerry()
	    	objSQL.SQLQuerry("INSERT INTO empleado\nVALUES ('1', 'Thomas', 'Edison', 'Estadounidense', '111222', '12');");  
	    	objSQL.SQLQuerry("INSERT INTO empleado\nVALUES ('2', 'Nikola', 'Tesla', 'Servio', '1236896', '12');"); 
	    	objSQL.SQLQuerry("INSERT INTO empleado\nVALUES ('4', 'Enrique', 'Gaviola', 'Argentino', '132435', '11');");    	
	    	objSQL.SQLQuerry("INSERT INTO empleado\nVALUES ('5', 'Steve', 'Jobs', 'Estadounidense', '321654', '12');");	
	    	objSQL.SQLQuerry("INSERT INTO empleado\nVALUES ('6', 'Alan', 'Turin', 'Ingles', '147258', '11');");	
	    	
	    	//Consulta: desde tabla y campos.
	    	System.out.println(objSQL.SQLRead("empleado", "apellido,nombre,nacionalidad,dni,idEmpleado"));
	    	
	    	//Actualiza campo nombres.
	    	objSQL.SQLQuerry("UPDATE empleado SET nombre='Alan Mathison' WHERE nombre = 'Alan'");
	    	
	    	//Borra filas de la base de datos.
	    	objSQL.SQLQuerry("DELETE FROM empleado WHERE nombre = 'Thomas'");
	    	
	    	//Consulta: desde tabla y campos.
	    	System.out.println(objSQL.SQLRead("empleado", "apellido,nombre,nacionalidad,dni,idEmpleado"));
    	}
    }
}
