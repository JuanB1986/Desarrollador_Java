package com.Ejercicios_Clase6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class calculadoraTest {	

	@Test
	public void prueba1() {	//1
		
		double n1=80.0f;
		double n2=3.0f;
		double valEsp=240.0;		
		assertEquals(valEsp,calculadora.multiplicar(n1, n2),0.0f);		//Se agrega tercer argumento DELTA.
	}
	
	@Test
	public void prueba2() {
		double n1=150.0f;
		double n2=180.0f;
		double n3=3.0;
		double valEsp=110.0f;		
		assertEquals(valEsp,calculadora.dividir(calculadora.sumar(n1, n2), n3),0.0f);				
	}
	
	@Test
	public void prueba3() {
		double n1=90.0f;
		double n2=50.0f;
		double n3=15.0;
		double valEsp=605.0f;		
		assertNotEquals(valEsp,calculadora.multiplicar(calculadora.restar(n1, n2), n3),0.0f);				
	}

	@Test
	public void prueba4() {
		double n1=70.0f;
		double n2=40.0f;
		double n3=25.0;
		double valEsp=2700.0f;		
		assertNotEquals(valEsp,calculadora.multiplicar(calculadora.sumar(n1, n2), n3),0.0f);				
	}
	
	
}
