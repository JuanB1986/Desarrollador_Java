package com.Ejercicios_Clase7;

import java.time.LocalDate;

public abstract class Descuento {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	//Metodo abstracto
	public abstract float getDescuento();
	
}
