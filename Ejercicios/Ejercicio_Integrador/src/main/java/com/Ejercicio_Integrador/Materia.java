package com.Ejercicio_Integrador;

import java.util.ArrayList;
import java.util.List;

public class Materia {

		private List <String> correlativas;
		private String nombre;		
		
		public Materia(String nombre) {
			this.correlativas=new ArrayList<String>();
			this.nombre=nombre;
		}
		
		public void setCorrelativas(String correlativas) {
			this.correlativas.add(correlativas);
		}
		
		public List <String> getCorrelativas() {
			return this.correlativas;
		}
		
		
		public String getNombre() {
			return this.nombre;
		}
				
		public boolean puedeCursar() {
			return false;
		}
		
		
	
}
