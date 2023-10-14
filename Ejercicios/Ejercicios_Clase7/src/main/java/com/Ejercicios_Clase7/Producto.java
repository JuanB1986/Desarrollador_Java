package com.Ejercicios_Clase7;


public class Producto {

	private String descripcion;
	private float precio;
	private float peso;
	
	public Producto(String descripcion, float precio, float peso) {
		this.descripcion=descripcion;
		this.precio=precio;
		this.peso=peso;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public float getPrecio() {
		return this.precio;
	}
	
	public void setPrecio(float precio) {
		this.precio=precio;
	}	
	
	public float getPeso() {
		return this.peso;
	}
	
	public void setPeso (float peso) {
		this.peso=peso;
	}
}
