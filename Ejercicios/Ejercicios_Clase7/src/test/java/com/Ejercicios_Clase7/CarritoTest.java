package com.Ejercicios_Clase7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

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
	public void PruebaMetodoGetPrecioTotal() {
		
		double precioEsperado;
		double precioCalculado;
		
		Producto 				objProductos[]=new Producto[10];
      	itemCarrito 			objItemCarrito[]=new itemCarrito[20];      	
      	DescuentoFijo 			objDescuentoFijo = new DescuentoFijo();
           	
		//Objetos productos.
		objProductos[0]=new Producto("Manzana", 80.0f, 0.25f);
		objProductos[1]=new Producto("Peras", 68.0f, 0.3f);
		
		//Objetos itemsCarrito
		objItemCarrito[0]=new itemCarrito(objProductos[0], 4);
		objItemCarrito[1]=new itemCarrito(objProductos[1], 5);
		
		//Objetos Compras
      	Carrito compra1 = new Carrito("26/02/2022", objDescuentoFijo );
      	
      	//Carga objetos carritos
      	compra1.agregarItem(objItemCarrito[0]);
      	compra1.agregarItem(objItemCarrito[1]);
     	
      	precioEsperado=compra1.getPrecioTotal();
      	
      	//precio teorico sin descuento fijo de 5%
      	precioCalculado = objProductos[0].getPrecio()*4 + objProductos[1].getPrecio()*5 ;
      	
      	//precio con porcentaje
      	precioCalculado -= precioCalculado*5/100;      	
      	
      	assertEquals(precioCalculado,precioEsperado,0.0f);
      	
	}
	
	/*************************************************************************
	 TEST 2: Cálculo del peso total del carrito, comparado con el valor teorico.
	**************************************************************************/	
	@Test
	public void PruebaMetodoGetPesoTotal() {
		
		double pesoEsperado;
		double pesoCalculado;
		
		Producto 				objProductos[]=new Producto[10];
      	itemCarrito 			objItemCarrito[]=new itemCarrito[20];      	
      	DescuentoFijo 			objDescuentoFijo = new DescuentoFijo();
           	
		//Objetos productos.
		objProductos[0]=new Producto("Manzana", 80.0f, 0.25f);
		objProductos[1]=new Producto("Peras", 68.0f, 0.3f);
		
		//Objetos itemsCarrito
		objItemCarrito[0]=new itemCarrito(objProductos[0], 4);
		objItemCarrito[1]=new itemCarrito(objProductos[1], 5);
		
		//Objetos Compras
      	Carrito compra1 = new Carrito("26/02/2022", objDescuentoFijo );
      	
      	//Carga objetos carritos
      	compra1.agregarItem(objItemCarrito[0]);
      	compra1.agregarItem(objItemCarrito[1]);
     	
      	pesoEsperado=compra1.getPesoTotal();
      	pesoCalculado = objProductos[0].getPeso()*4 + objProductos[1].getPeso()*5 ;
      	
       	assertEquals(pesoCalculado,pesoEsperado,0.0f);      	
	}
	
	
	/*************************************************************************
	 TEST 3: DescuentoPorcentajeConTope
	**************************************************************************/	
	@Test
	public void PruebaMetodoDescuentoPorcentajeConTope() {
		
		DescuentoPorcentajeConTope objDescuentoPorcentajeConTope=new DescuentoPorcentajeConTope(12.3f);
		
		double porcentaje=12.3f;		
		double valorTeorico = objDescuentoPorcentajeConTope.getDescuento();
		
		assertEquals(valorTeorico, porcentaje, 0.0f);
	}
	
	
	/*************************************************************************
	 TEST 4: DescuentoPorcentajeConTope. Prueba limite del tope 20%
	**************************************************************************/	
	@Test
	public void PruebaMetodoDescuentoPorcentajeConTope2() {
		
		DescuentoPorcentajeConTope objDescuentoPorcentajeConTope=new DescuentoPorcentajeConTope(21.3f);
		
		double porcentaje=21.3f;		
		double valorTeorico = objDescuentoPorcentajeConTope.getDescuento();
		
		assertNotEquals(valorTeorico, porcentaje, 0.0f);
	}
	
	
	
}
