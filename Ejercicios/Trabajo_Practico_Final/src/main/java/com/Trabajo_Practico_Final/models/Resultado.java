package com.Trabajo_Practico_Final.models;

import java.util.ArrayList;
import java.util.List;

public class Resultado {
	
	private List<Pronostico> pronosticos;
	private List<String> participantes;
	private int puntaje[];
	private int aciertos[];
	
	public Resultado(List<Pronostico> pronosticos) {
		
		this.pronosticos = new ArrayList<Pronostico>();
		this.pronosticos = pronosticos;
		this.participantes=new ArrayList<String>();			//Listo los participantes en este arrayList
		
	}
	
	public void procesar() {
		
		//Lista los participantes
		for (Pronostico pron : pronosticos) {
			boolean flag=true;
			for(String particip : participantes) {
				if(pron.getPersona().equals(particip)) {
					flag=false;
				}
			}
			if (flag) {this.participantes.add(pron.getPersona());}
		}		
		
		puntaje = new int [this.participantes.size()];		
		aciertos = new int [this.participantes.size()];
		
		//Calcula Puntaje
		for (Pronostico pron : pronosticos) 
		{
			for(int j=0;j<this.participantes.size();++j) 
			{
				if (this.participantes.get(j).equals(pron.getPersona())) 
				{
					puntaje[j] += pron.getPuntaje();					
					
					if (!(pron.getPuntaje()==0)) {
						aciertos[j] += 1;
					}
				}
			}
		}	
		
		//Suma puntaje extra por aciertos de rondas completas
		for (int i=0; i<participantes.size();++i) {
			puntaje[i] += ReglasPuntaje.puntosAciertosPorRondas(pronosticos, participantes.get(i));
		}	
		
	}	
	
	//Muestra participantes, puntajes y aciertos
	public void mostrar() {		
		for(int j=0;j<this.participantes.size();++j) {
			System.out.println(this.participantes.get(j) + ": Puntaje: "+puntaje[j]+" - Aciertos "+aciertos[j]);
		}
	}


}
