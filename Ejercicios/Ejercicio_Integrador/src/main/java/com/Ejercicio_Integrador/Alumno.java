package com.Ejercicio_Integrador;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	
	private String nombre;
	private String legajo;
	private List<String> materiasAprobadas;
	
	
	public Alumno() {
		materiasAprobadas = new ArrayList<String>();
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setLegajo(String legajo) {
		this.legajo=legajo;
	}
	
	public String getLegajo() {
		return this.legajo;
	}
	
	public void setMateriasAprobadas(String materiaAp) {
		this.materiasAprobadas.add(materiaAp);
	}
	
	public List<String> getMateriasAprobadas() {
		return this.materiasAprobadas;
	}
	
}
