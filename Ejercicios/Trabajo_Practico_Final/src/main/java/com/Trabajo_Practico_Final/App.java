package com.Trabajo_Practico_Final;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.Trabajo_Practico_Final.drivers.DBCargaPronosticos;
import com.Trabajo_Practico_Final.drivers.DBCargaRondas;
import com.Trabajo_Practico_Final.drivers.Prode;
import com.Trabajo_Practico_Final.JFrame.HmiData;
import com.Trabajo_Practico_Final.JFrame.HmiLaunchApp;
import com.Trabajo_Practico_Final.drivers.CsvCargaPronosticos;
import com.Trabajo_Practico_Final.drivers.CsvCargaRondas;
import com.Trabajo_Practico_Final.drivers.SQL;
import com.Trabajo_Practico_Final.models.*;


public class App {
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/mundial";	
	public static final String user = "root";
	public static final String password = "juan";	

	public static  void main(String[] args) throws IOException{
		
		
		/**********************************************************************************************************************************************/
		// Proceso archivos .CSV
		/**********************************************************************************************************************************************/

		
		List<Ronda> listaRondas = new ArrayList<Ronda>();
		List<Pronostico> listaPronosticos = new ArrayList<Pronostico>();
		
		//Lee y carga lista de rondas
		listaRondas = CsvCargaRondas.load("./Recursos/Rondas.csv");		
		
		//Carga lista de pronosticos desde archivo .CSV.			
		listaPronosticos = CsvCargaPronosticos.load("./Recursos/Pronostico.csv", listaRondas);
		
		//Resultados
		String ResultadosCSV = Prode.getResultados(listaPronosticos);
		System.out.println("***********Leyendo datos archivos .CSV**************");
		System.out.print(ResultadosCSV);
		System.out.println("****************************************************");
			
		
		/**********************************************************************************************************************************************/
		// Proceso archivos desde SQL
		/**********************************************************************************************************************************************/

		List<Ronda> listaRondasDB = new ArrayList<Ronda>();
		List<Pronostico> listaPronosticosDB = new ArrayList<Pronostico>();
		
		String partidos="", pronosticos="";
		
		//Lee base de datos
		if (SQL.Connect(DB_URL, user, password)) {			
	    	partidos = SQL.Read("SELECT * FROM partido", "idPartido, Equipo1, GolesEquipo1, GolesEquipo2, Equipo2, Ronda");
	    	pronosticos = SQL.Read("SELECT * FROM pronosticos", "idPronosticos, Nombre, GanaEquipo1, Empate, GanaEquipo2, idPartido");	
		}			
		
		SQL.Close();
		
		//Instacion objetos Partido		
		listaRondasDB = DBCargaRondas.load(partidos);		
				
		//Instancio Pronosticos	
		listaPronosticosDB =DBCargaPronosticos.load(listaRondasDB, pronosticos );
		
		//Resultados		
		String ResultadosDB = Prode.getResultados(listaPronosticosDB);
		System.out.println("***********Leyendo datos de la base MySQL***********");
		System.out.print(ResultadosDB);
		System.out.println("****************************************************\n");
		
		
		//Interfaz Gráfica
		HmiData.setLblResultado1(ResultadosCSV);
		HmiData.setLblResultado2(ResultadosDB);
		HmiLaunchApp.show();		
	}
}
