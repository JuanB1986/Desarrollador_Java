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
		this.participantes=new ArrayList<String>();		
		
	}
	
	public void computar() {
		
		//Lista los participantes
		for (int i=0;i<this.pronosticos.size();++i) {
			boolean flag=true;
			for(int j=0;j<this.participantes.size();++j) {
				if(this.pronosticos.get(i).getPersona().equals(this.participantes.get(j))) {
					flag=false;
				}
			}
			if (flag) {this.participantes.add(this.pronosticos.get(i).getPersona());}
		}		
		
		puntaje = new int [this.participantes.size()];		
		aciertos = new int [this.participantes.size()];
		
		//Puntaje
		for (int i=0;i<this.pronosticos.size();++i) {
			for(int j=0;j<this.participantes.size();++j) {
				if (this.participantes.get(j).equals(this.pronosticos.get(i).getPersona())) {
					puntaje[j] += this.pronosticos.get(i).getPuntaje();	
					
					if (!(this.pronosticos.get(i).getPuntaje()==0)) {
						aciertos[j] += 1;
					}
				}
			}
		}		
	}
	
	
	public void mostrar() {		
		for(int j=0;j<this.participantes.size();++j) {
			System.out.println(this.participantes.get(j) + ": Puntaje: "+puntaje[j]+" - Aciertos "+aciertos[j]);
		}
	}
	

}
