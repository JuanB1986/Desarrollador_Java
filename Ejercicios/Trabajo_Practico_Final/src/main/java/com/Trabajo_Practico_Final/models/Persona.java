package com.Trabajo_Practico_Final.models;

import lombok.Data;

public @Data class Persona {
	
	private String nombre;
	//private PronRonda[] rondas;
	
	public Persona(String nombre) {
		this.setNombre(nombre);

	}	

}
