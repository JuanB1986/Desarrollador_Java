package com.Ejercicios_Clase7;

public class DescuentoPorcentajeConTope extends Descuento{
	
	private float tope;
	private float descuento;
	
	//Constructor
	public DescuentoPorcentajeConTope(float descuento) {
		super();
		this.descuento=descuento;
		this.tope=20.0f;
	}
	
	//Metodo obtener descuento
	public float getDescuento() {
		if (this.descuento>this.tope) {
			return this.tope;
		}
		else {
			return this.descuento;
		}
	}
	
	//Metodo get tope
	public float getTope(float tope) {
		return this.tope=tope;
	}	

}
