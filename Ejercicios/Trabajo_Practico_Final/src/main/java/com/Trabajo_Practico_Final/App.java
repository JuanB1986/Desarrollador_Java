package com.Trabajo_Practico_Final;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Trabajo_Practico_Final.drivers.SQL;
import com.Trabajo_Practico_Final.models.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class App {
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/qatar2022";	
	public static final String user = "root";
	public static final String password = "juan";	

	@SuppressWarnings("null")
	public static  void main(String[] args) throws IOException{
		
		//Prueba lectura de la base de datos
		SQL objSQLDriver = new SQL();
		if (objSQLDriver.SQLConnect(DB_URL, user, password)) {
	    	System.out.println(objSQLDriver.SQLRead("empleado", "apellido,nombre,nacionalidad,dni,idEmpleado"));
		}
			
		
		Partido objPartido;
		Equipo objEquipo1, objEquipo2;
		Ronda objRonda;
		Pronostico objPronostico;
		List<Ronda> listaRondas = new ArrayList<Ronda>();
		List<Pronostico> listaPronosticos = new ArrayList<Pronostico>();
		
		//Carga lista de Rondas.
		try {
			CSVReader rondasCSV;
			rondasCSV = new CSVReader(new FileReader("./Recursos/Rondas.csv"));
			String[] fila = null;
			while((fila = rondasCSV.readNext()) != null) {
				//System.out.println(fila[0] + " | " + fila[1] + " | " + fila[2] + " | " + fila[3] + " | " + fila[4]);
				
				objEquipo1=new Equipo(fila[1]);
				objEquipo2=new Equipo(fila[4]);
				objPartido = new Partido(objEquipo1,Integer.parseInt(fila[2].strip()),Integer.parseInt(fila[3].strip()),objEquipo2);								
				objRonda = new Ronda(fila[0], objPartido);
				listaRondas.add(objRonda);						
			}		
		}
		catch (CsvValidationException e){}
		catch (FileNotFoundException d) {System.out.println("Archivo no encontrado");}
		
				
		
		//Carga lista de pronosticos.
		try {
			CSVReader pronosticosCSV;
			pronosticosCSV = new CSVReader(new FileReader("./Recursos/Pronostico.csv"));
			String[] fila = null;
			int i=0;
			String result="";
			while((fila = pronosticosCSV.readNext()) != null) {
				//System.out.println(fila[0] + " | " + fila[1] + " | " + fila[2] + " | " + fila[3] + " | " + fila[4]+ " | " + fila[5]);
	
				if (fila[2].toLowerCase().strip().equals("x")){result="Gana1";}
				if (fila[3].toLowerCase().strip().equals("x")){result="Empate";}
				if (fila[4].toLowerCase().strip().equals("x")){result="Gana2";}				
				
				for (i=0; i<listaRondas.size();++i) {					
					
					if (listaRondas.get(i).getPartido().getEquipo1().getNombre().toLowerCase().strip().equals(fila[1].toLowerCase().strip()) &&
						listaRondas.get(i).getPartido().getEquipo2().getNombre().toLowerCase().strip().equals(fila[5].toLowerCase().strip())) 
					{					
						objPronostico = new Pronostico(listaRondas.get(i),fila[0],result);
						listaPronosticos.add(objPronostico);
					}
				}					
			}		
		}
		catch (CsvValidationException e){}
		catch (FileNotFoundException d) {System.out.println("Archivo no encontrado");}
		
		
		//Prueba 
		/*for (int i=0; i<listaPronosticos.size();++i) {			
			System.out.print("ronda: "+listaPronosticos.get(i).getRonda().getRonda()+" ");	
			System.out.print(listaPronosticos.get(i).getPersona()+" ");				
			System.out.println(listaPronosticos.get(i).getPuntaje());			
		}*/
		
		//Resultados
		Resultado objResultado=new Resultado(listaPronosticos);
		objResultado.computar();
		objResultado.mostrar();
		
	}

}
