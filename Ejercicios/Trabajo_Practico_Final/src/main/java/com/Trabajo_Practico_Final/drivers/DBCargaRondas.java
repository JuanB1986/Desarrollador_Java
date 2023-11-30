package com.Trabajo_Practico_Final.drivers;

import java.util.ArrayList;
import java.util.List;

import com.Trabajo_Practico_Final.models.Equipo;
import com.Trabajo_Practico_Final.models.Partido;
import com.Trabajo_Practico_Final.models.Ronda;

public abstract class DBCargaRondas {
	
	public DBCargaRondas() {}	
	
	//Método de carga partidos
	public static List<Ronda> load(String partidos){
		Partido objPartido;
		Ronda   objRonda;
		List<Ronda> listaRondas = new ArrayList<Ronda>();
		
		String split[];
		
		//Instacion objetos Partido
		split = partidos.split(",");
		for (int i=0; i<(split.length-1)/6;++i) {
			Equipo equipo1= new Equipo(split[1+6*i].strip());
			Equipo equipo2= new Equipo(split[4+6*i].strip());			
			objPartido = new Partido(Integer.parseInt(split[0+6*i].strip()), equipo1, Integer.parseInt(split[2+6*i].strip()), Integer.parseInt(split[3+6*i].strip()), equipo2);
			objRonda = new Ronda(split[5+6*i], objPartido);
			listaRondas.add(objRonda);
		}
		
		return listaRondas;
	}
	
	

}
