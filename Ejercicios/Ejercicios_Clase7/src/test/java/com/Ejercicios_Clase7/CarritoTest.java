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
		
		//Objetos productos
		Producto objProductos[]=new Producto[20]; 
		
		//Objetos Compras
		Carrito compra1=new Carrito();

		//Objetos Descuentos
		DescuentoPorcentaje objDescuentoPorcentaje = new DescuentoPorcentaje(6.3f);	
		
		//Carga objeto productos.
		objProductos[0]=new Producto("Manzana", 150.2f, 0.12f);
		objProductos[1]=new Producto("Peras", 102f, 0.1f);
		objProductos[2]=new Producto("Bananas", 110f, 0.15f);		
		objProductos[3]=new Producto("Pasta dental", 239.5f, 0.05f);
		objProductos[4]=new Producto("Cepillo de dientes", 187.0f, 0.03f);		
		objProductos[5]=new Producto("Cerveza Importada Hoegaarden", 900f, 0.5f);
		objProductos[6]=new Producto("Cerveza Importada Erdinger", 850.0f, 0.5f);
		objProductos[7]=new Producto("Cerveza Importada Grolsch", 3200.0f, 1.0f);		
		
		//Compras
		compra1.agregarProducto(objProductos[0],6);
		compra1.agregarProducto(objProductos[3],2);
		compra1.agregarProducto(objProductos[4],3);
		compra1.agregarProducto(objProductos[7],3);
		
		compra1.calcularPrecioTotal(objDescuentoPorcentaje);
		
		//Calculos 
		double precioEsperado=compra1.getPrecioTotalDescuento();
		double precioCalculado= 6.0f*150.2f + 239.5f*2.0f + 3.0f*187.0f + 3.0f*3200.0f;
		precioCalculado -= precioCalculado*objDescuentoPorcentaje.getDescuento()/100.0f;  //Calcula descuento
		
      	assertEquals(precioCalculado,precioEsperado,0.01f);
      	
      	/************************************************************************************************ 
      	 * NOTA: agrego 0.01f al delta del metodo assertEquals porque se produce un error de redondeo
      	 como muestro a continuacion:
      	  
      	  CarritoTest.PruebaMetodoGetPrecioTotal:59 expected:<10814.10456099472> but was:<10814.1044921875>     
      	  
      	  Puede darse en la conversion FLOTAT -> DOUBLE; 
      	  porque el metodo getPrecioTotalDescuento() devuelve FLOAT.      	 
      	 ************************************************************************************************/     	
	}
	
	
	/*************************************************************************
	 TEST 2: Cálculo del peso total del carrito, comparado con el valor teorico.
	**************************************************************************/	
	@Test
	public void PruebaMetodoGetPesoTotal() {
		
		//Objetos productos
		Producto objProductos[]=new Producto[20]; 
		
		//Objetos Compras
		Carrito compra2=new Carrito();

		//Objetos Descuentos
		DescuentoFijo objDescuentoFijo = new DescuentoFijo();
		
		//Carga objeto productos.
		objProductos[0]=new Producto("Manzana", 150.2f, 0.12f);
		objProductos[1]=new Producto("Peras", 102.0f, 0.1f);
		objProductos[2]=new Producto("Bananas", 110.0f, 0.15f);		
		objProductos[3]=new Producto("Pasta dental", 239.5f, 0.05f);
		objProductos[4]=new Producto("Cepillo de dientes", 187.0f, 0.03f);		
		objProductos[5]=new Producto("Cerveza Importada Hoegaarden", 900f, 0.5f);
		objProductos[6]=new Producto("Cerveza Importada Erdinger", 850.0f, 0.5f);
		objProductos[7]=new Producto("Cerveza Importada Grolsch", 3200.0f, 1.0f);		
		
		//Compras
		compra2.agregarProducto(objProductos[2],2);
		compra2.agregarProducto(objProductos[1],4);
		compra2.agregarProducto(objProductos[0],5);
		
		compra2.calcularPrecioTotal(objDescuentoFijo);
		
		double pesoEsperado = compra2.getPesoTotal();
		double pesoCalculado = 0.15f*2 + 4*0.1f + 5*0.12f;	

      	
       	assertEquals(pesoCalculado,pesoEsperado,0.0f);      	
	}
	
	
	/*************************************************************************
	 TEST 3: DescuentoPorcentajeConTope
	**************************************************************************/	
	@Test
	public void PruebaMetodoDescuentoPorcentajeConTope() {
		
		//Objetos Compras
		Carrito compra3=new Carrito("./compra.dat");

		//Objetos Descuentos
		DescuentoPorcentajeConTope objDescuentoPorcentajeConTope = new DescuentoPorcentajeConTope(7.1f);
		
		compra3.calcularPrecioTotal(objDescuentoPorcentajeConTope);
		
		double precioEsperado= compra3.getPrecioTotalDescuento();		
		double precioCalculado = 2.0f*1520.3f + 1200.0f + 526.3f*4.0f + 1250.0f*5.0f + 187.5f*3.0f + 950.0f + 410.0f;
		precioCalculado -= precioCalculado*objDescuentoPorcentajeConTope.getDescuento()/100.0f;
		
		assertEquals(precioCalculado, precioEsperado, 0.01f);
		
		/************************************************************************************************************
		 Aca tambien agrego el parametro Delta en 0.01f.
		 Existe un error de redondeo FLOAT -> DOUBLE:
		 CarritoTest.PruebaMetodoDescuentoPorcentajeConTope:134 expected:<13487.500532400418> but was:<13487.5>
		 ************************************************************************************************************/
		
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
