package com.Trabajo_Practico_Final.drivers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Trabajo_Practico_Final.models.Pronostico;
import com.Trabajo_Practico_Final.models.Ronda;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public abstract class CsvCargaPronosticos {
	
	public CsvCargaPronosticos() {}
	
	//Arma la lista de pronosticos
	public static List<Pronostico> load(String ruta, List<Ronda> listaRondas ) throws IOException{
		
		List<Pronostico> listaPronosticos = new ArrayList<Pronostico>();
		Pronostico objPronostico;		
		
		try {
			CSVReader pronosticosCSV;
			pronosticosCSV = new CSVReader(new FileReader(ruta));
			String[] fila = null;
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
		
		return listaPronosticos;
	}
}
