package com.Trabajo_Practico_Final.drivers;

import java.util.ArrayList;
import java.util.List;

import com.Trabajo_Practico_Final.models.Pronostico;
import com.Trabajo_Practico_Final.models.ReglasPuntaje;

public abstract class Prode {
	
	private static List<String> participantes;
	private static int puntaje[];
	private static int aciertos[];
	
	public Prode() {}
	
	public static String getResultados(List<Pronostico> pronosticos) {
				
		participantes=new ArrayList<String>();
		
		//Lista los participantes
		for (Pronostico pron : pronosticos) {
			boolean flag=true;
			for(String particip : participantes) {
				if(pron.getPersona().equals(particip)) {
					flag=false;
				}
			}
			if (flag) {participantes.add(pron.getPersona());}
		}		
		
		puntaje = new int [participantes.size()];		
		aciertos = new int [participantes.size()];
		String resultados="";
		
		//Calcula Puntaje
		for (Pronostico pron : pronosticos) 
		{
			for(int j=0;j<participantes.size();++j) 
			{
				if (participantes.get(j).equals(pron.getPersona())) 
				{
					puntaje[j] += pron.getPuntaje();					
					
					if (!(pron.getPuntaje()==0)) {
						aciertos[j] += 1;
					}					
				}				
			}			
		}	
		
		//Suma puntaje extra por aciertos de rondas e imprime resultado en cadena
		for (int i=0; i<participantes.size();++i) {
			puntaje[i] += ReglasPuntaje.puntosAciertosPorRondas(pronosticos, participantes.get(i));
			resultados += participantes.get(i) + ": Puntaje: " + puntaje[i] + " Aciertos: " + aciertos[i] + "\n";
		}		
		
		return resultados;
	}
}
