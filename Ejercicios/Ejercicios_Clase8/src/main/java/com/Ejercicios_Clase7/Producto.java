package com.Ejercicios_Clase7;
import com.Ejercicios_Clase7.Excepciones.NegativePriceException;
import com.Ejercicios_Clase7.Excepciones.NullPriceException;


public class Producto {

	private String descripcion;
	private float precio;
	private float peso;
	
	public Producto()
	{

	}
	
	public Producto(String descripcion, float precio, float peso)
	{
		this.descripcion=descripcion;
		this.precio=precio;
		this.peso=peso;		
	}

	public float getPrecio() throws NullPriceException, NegativePriceException{
		if ( this.precio == 0.0f) {
			throw new NullPriceException();
		}
		
		if (this.precio < 0.0f) {
			throw new NegativePriceException();
		}
		return this.precio;
	}

	
	public float getPeso() {
		return this.peso;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setPrecio(float precio) {
		this.precio=precio;
	}
	
	public void setPeso(float peso) {
		this.peso=peso;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
}
