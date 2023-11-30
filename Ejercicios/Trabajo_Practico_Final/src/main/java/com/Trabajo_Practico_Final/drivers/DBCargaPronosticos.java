package com.Trabajo_Practico_Final.drivers;

import java.util.ArrayList;
import java.util.List;
import com.Trabajo_Practico_Final.models.Pronostico;
import com.Trabajo_Practico_Final.models.Ronda;

public abstract class DBCargaPronosticos {	
	
	public DBCargaPronosticos() {}
	
	//Método: arma lista de pronosticos
	public static List<Pronostico> load(List<Ronda> listaRondas, String pronosticos){
		
		List<Pronostico> listaPronosticos = new ArrayList<Pronostico>();		
		String split[];
		
		//Instancio Pronosticos				
		split=null;
		split = pronosticos.split(",");
		for (int i=0; i<(split.length-1)/6;++i) 
		{
			Pronostico objPronosticoDB;
			Ronda rondaTemp=null;
			
			for ( Ronda ronda : listaRondas)
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
			listaPronosticos.add(objPronosticoDB);
			
		}
		return listaPronosticos;
	}
}
