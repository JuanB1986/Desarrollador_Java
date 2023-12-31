package com.Ejercicios_Clase7;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.Ejercicios_Clase7.Excepciones.NegativePriceException;
import com.Ejercicios_Clase7.Excepciones.NullPriceException;

public class CarritoTest {
	private static int count=1;
	
	@Before
	public void PruebaBefore() {
		
		System.out.println("**** Pre ejecucion - Test Nro: "+count+" ****");
		++count;
	}
	
	
	/*************************************************************************
	 TEST 1: Cálculo teorico del precio total del carrito y comparado con el 
	 metodo del carrito getPrecioTotal(), que obtiene el precio total con dcto.
	**************************************************************************/	
	@Test
	public void PruebaMetodoGetPrecioTotal() throws NullPriceException, NegativePriceException {
		
		
		//Objetos productos
		Producto objProductos[]=new Producto[20]; 
		itemCarrito objItem[]=new itemCarrito[10];
				
		//Objetos Compras
		Carrito carrito1=new Carrito();

		//Objetos Descuentos
		DescuentoPorcentajeConTope objDecuentoConTope = new DescuentoPorcentajeConTope(7.1f);
		
		//Carga objeto productos.
		objProductos[0]=new Producto("Manzana", 150.2f, 0.12f);
		objProductos[1]=new Producto("Peras", 102f, 0.1f);
		objProductos[2]=new Producto("Bananas", 110f, 0.15f);		
		
		//Objetos items carrito
		objItem[0] = new itemCarrito (objProductos[0],10);
		objItem[1] = new itemCarrito (objProductos[1],3);
		objItem[2] = new itemCarrito (objProductos[2],5);
			
		//Objetos carrito
		carrito1.add(objItem[0]);
		carrito1.add(objItem[1]);
		carrito1.add(objItem[2]);

		
		//Calculos 
		double precioEsperado=carrito1.precioTotal(objDecuentoConTope);
		
		double precioCalculado= 10.0f*150.2f + 3.0f*102.0f + 110.0f*5.0f;
		
		precioCalculado -= precioCalculado*objDecuentoConTope.getDescuento()/100.0f;  	
		
      	assertEquals(precioCalculado,precioEsperado,0.0f);
      	
  	
	}
	
	
	/*************************************************************************
	 TEST 2: Cálculo del peso total del carrito, comparado con el valor teorico.
	**************************************************************************/	
	@Test
	public void PruebaMetodoGetPesoTotal() throws NullPriceException, NegativePriceException{
		
		//Objetos productos
		Producto objProductos[]=new Producto[20]; 
		itemCarrito objItem[]=new itemCarrito[10];
				
		//Objetos Compras
		Carrito carrito1=new Carrito();

		//Carga objeto productos.
		objProductos[0]=new Producto("Manzana", 150.2f, 0.12f);
		objProductos[1]=new Producto("Peras", 102f, 0.1f);
		objProductos[2]=new Producto("Bananas", 110f, 0.15f);		
		
		//Objetos items carrito
		objItem[0] = new itemCarrito (objProductos[0],10);
		objItem[1] = new itemCarrito (objProductos[1],3);
		objItem[2] = new itemCarrito (objProductos[2],5);
			
		//Objetos carrito
		carrito1.add(objItem[0]);
		carrito1.add(objItem[1]);
		carrito1.add(objItem[2]);
		
		double pesoEsperado = carrito1.getPesoTotal();
		
		double pesoCalculado = 0.15f*5 + 3*0.1f + 10*0.12f;	
      	
       	assertEquals(pesoCalculado,pesoEsperado,0.01f);      	
	}
	
	
	/*************************************************************************
	 TEST 3: DescuentoPorcentajeConTope
	**************************************************************************/	
	@Test
	public void PruebaMetodoDescuentoPorcentajeConTope() throws NullPriceException, NegativePriceException{
		Carrito carrito3 = new Carrito();
		
		try {
			carrito3.add("./compra.dat");
		}
		catch(IOException e) {}
		
		//Objetos Descuentos
		DescuentoPorcentajeConTope objDecuentoConTope = new DescuentoPorcentajeConTope(7.1f);
		
		double precioEsperado= carrito3.precioTotal(objDecuentoConTope);
		
		double precioCalculado = 2.0f*1520.3f + 1200.0f + 526.3f*4.0f + 1250.0f*5.0f + 187.5f*3.0f + 950.0f + 410.0f;
		
		precioCalculado -= precioCalculado*objDecuentoConTope.getDescuento()/100.0f;
				
		assertEquals(precioCalculado, precioEsperado, 0.01f);			
		
	}		
}
