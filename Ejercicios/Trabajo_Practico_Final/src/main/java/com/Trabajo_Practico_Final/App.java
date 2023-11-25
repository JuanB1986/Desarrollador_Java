package com.Trabajo_Practico_Final;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Trabajo_Practico_Final.drivers.SQL;
import com.Trabajo_Practico_Final.models.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class App {
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/mundial";	
	public static final String user = "root";
	public static final String password = "juan";	

	public static  void main(String[] args) throws IOException{
		
		SQL objSQLDriver = new SQL();		
		Partido partidoDB;
		Ronda   rondaDB;
		List<Ronda> listaRondasDB = new ArrayList<Ronda>();
		List<Pronostico> listaPronosticosDB = new ArrayList<Pronostico>();
		
		String partidos="", pronosticos="", split[];
		
		//Lee base de datos
		if (objSQLDriver.SQLConnect(DB_URL, user, password)) {			
	    	partidos = objSQLDriver.SQLRead("SELECT * FROM partido", "idPartido, Equipo1, GolesEquipo1, GolesEquipo2, Equipo2, Ronda");
	    	pronosticos = objSQLDriver.SQLRead("SELECT * FROM pronosticos", "idPronosticos, Nombre, GanaEquipo1, Empate, GanaEquipo2, idPartido");	    	
		}			
		
		//Instacion objetos Partido
		split = partidos.split(",");
		for (int i=0; i<(split.length-1)/6;++i) {
			Equipo equipo1= new Equipo(split[1+6*i].strip());
			Equipo equipo2= new Equipo(split[4+6*i].strip());			
			partidoDB = new Partido(Integer.parseInt(split[0+6*i].strip()), equipo1, Integer.parseInt(split[2+6*i].strip()), Integer.parseInt(split[3+6*i].strip()), equipo2);
			rondaDB = new Ronda(split[5+6*i], partidoDB);
			listaRondasDB.add(rondaDB);
		}
				
		//Instancio Pronosticos				
		split=null;
		split = pronosticos.split(",");
		for (int i=0; i<(split.length-1)/6;++i) 
		{
			Pronostico objPronosticoDB;
			Ronda rondaTemp=null;
			
			for ( Ronda ronda : listaRondasDB)
			{
				if (ronda.getPartido().getIdPartido()==Integer.parseInt(split[5+6*i].strip())) {
					rondaTemp = ronda;
				}				
			}
			String result=null;
			if (split[2+6*i].toLowerCase().strip().equals("x")){result="Gana1";}
			if (split[3+6*i].toLowerCase().strip().equals("x")){result="Empate";}
			if (split[4+6*i].toLowerCase().strip().equals("x")){result="Gana2";}	
			
			objPronosticoDB = new Pronostico(rondaTemp, split[1+6*i].strip(), result); 				
			listaPronosticosDB.add(objPronosticoDB);
			
		}			
		
		//Resultados
		Resultado objResult=new Resultado(listaPronosticosDB);
		
		objResult.procesar();			
		System.out.println("***********Leyendo datos de la base MySQL***********");
		objResult.mostrar();
		System.out.println("****************************************************\n");
		
		
				
		/**********************************************************************************************************************************************/
		// Proceso archivos .CSV
		/**********************************************************************************************************************************************/
		
		Partido objPartido;
		Equipo objEquipo1, objEquipo2;
		Ronda objRonda;
		Pronostico objPronostico;
		List<Ronda> listaRondas = new ArrayList<Ronda>();
		List<Pronostico> listaPronosticos = new ArrayList<Pronostico>();
		
		//Carga lista de Rondas desde archivo .CSV.
		try {
			CSVReader rondasCSV;
			rondasCSV = new CSVReader(new FileReader("./Recursos/Rondas.csv"));
			String[] fila = null;
			while((fila = rondasCSV.readNext()) != null) {
		
				objEquipo1=new Equipo(fila[1]);
				objEquipo2=new Equipo(fila[4]);
				objPartido = new Partido(objEquipo1,Integer.parseInt(fila[2].strip()),Integer.parseInt(fila[3].strip()),objEquipo2);								
				objRonda = new Ronda(fila[0], objPartido);
				listaRondas.add(objRonda);						
			}		
		}
		catch (CsvValidationException e){}
		catch (FileNotFoundException d) {System.out.println("Archivo no encontrado");}
		
				
		
		//Carga lista de pronosticos desde archivo .CSV.
		try {
			CSVReader pronosticosCSV;
			pronosticosCSV = new CSVReader(new FileReader("./Recursos/Pronostico.csv"));
			String[] fila = null;
			int i=0;
			String result="";
			while((fila = pronosticosCSV.readNext()) != null) {

				if (fila[2].toLowerCase().strip().equals("x")){result="Gana1";}
				if (fila[3].toLowerCase().strip().equals("x")){result="Empate";}
				if (fila[4].toLowerCase().strip().equals("x")){result="Gana2";}				
				
				for (Ronda ronda : listaRondas) {	
					
					if (ronda.getPartido().getEquipo1().getNombre().toLowerCase().strip().equals(fila[1].toLowerCase().strip()) &&
						ronda.getPartido().getEquipo2().getNombre().toLowerCase().strip().equals(fila[5].toLowerCase().strip())) 
					{					
						objPronostico = new Pronostico(ronda,fila[0],result);
						listaPronosticos.add(objPronostico);
					}
				}					
			}		
		}
		catch (CsvValidationException e){}
		catch (FileNotFoundException d) {System.out.println("Archivo no encontrado");}
		
		//Resultados
		Resultado objResultado=new Resultado(listaPronosticos);
		objResultado.procesar();
		System.out.println("***********Leyendo datos archivos .CSV**************");
		objResultado.mostrar();
		System.out.println("****************************************************");
		
	}

}
