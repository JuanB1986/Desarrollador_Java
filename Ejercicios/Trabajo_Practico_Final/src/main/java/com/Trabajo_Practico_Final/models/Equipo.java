package com.Trabajo_Practico_Final.models;


import lombok.Data;

public @Data class Equipo {

	private String nombre;
	private String descripcion;
	
	public Equipo (String nombre) {
		this.setNombre(nombre);
	}
}
