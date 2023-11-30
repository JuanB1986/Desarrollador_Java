package com.Trabajo_Practico_Final.drivers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Trabajo_Practico_Final.models.Equipo;
import com.Trabajo_Practico_Final.models.Partido;
import com.Trabajo_Practico_Final.models.Ronda;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public abstract class CsvCargaRondas {
	
	public CsvCargaRondas() {}	
	
	public static List<Ronda> load(String ruta) throws IOException{
		
		Partido objPartido;
		Equipo objEquipo1, objEquipo2;
		Ronda objRonda;
		List<Ronda> listaRondas = new ArrayList<Ronda>();
		
		//Carga lista de Rondas desde archivo .CSV.
		try {
			CSVReader rondasCSV;
			rondasCSV = new CSVReader(new FileReader(ruta));
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
		
		return listaRondas;
	}

}
