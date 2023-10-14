package com.Ejercicios_Clase7;

public class DescuentoPorcentaje extends Descuento{
	
	private float descuento;
	
	//Constructor
	public DescuentoPorcentaje(float descuento) {
		super();
		this.descuento=descuento;
	}
	
	//Metodo 
	public float getDescuento(){
		
		return this.descuento;
	}
	
	//Metodo 
	public void setDescuento(float descuento) {
		this.descuento=descuento;
	}
	
}
