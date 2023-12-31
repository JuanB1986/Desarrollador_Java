package com.Ejercicios_Clase7;

import java.io.IOException;

import com.Ejercicios_Clase7.Excepciones.NegativePriceException;
import com.Ejercicios_Clase7.Excepciones.NullPriceException;

public class App {

	public static void main(String[] args)throws NegativePriceException, NullPriceException {		
		
    	/****************************************************************************************************	
   	 	Ejercicio Clase 8:  	
    	*****************************************************************************************************/
		
		//Objetos productos
		Producto objProductos[]=new Producto[20]; 
		itemCarrito objItem[]=new itemCarrito[10];
				
		//Objetos Compras
		Carrito carrito1=new Carrito();
		Carrito carrito2=new Carrito();
		Carrito carrito3=new Carrito();
		Carrito carrito4=new Carrito();
		Carrito carrito5=new Carrito();

		//Objetos Descuentos
		DescuentoFijo objDescuentoFijo = new DescuentoFijo();
		DescuentoPorcentaje objDescuentoPorcentaje = new DescuentoPorcentaje(6.3f);	
		DescuentoPorcentajeConTope objDecuentoConTope = new DescuentoPorcentajeConTope(7.1f);
		
		//Carga objeto productos.
		objProductos[0]=new Producto("Manzana", 150.2f, 0.12f);
		objProductos[1]=new Producto("Peras", 102f, 0.1f);
		objProductos[2]=new Producto("Bananas", 110f, 0.15f);		
		objProductos[3]=new Producto("Pasta dental", 239.5f, 0.05f);
		objProductos[4]=new Producto("Cepillo de dientes", 187.0f, 0.03f);		
		objProductos[5]=new Producto("Cerveza Importada Hoegaarden", 900f, 0.5f);
		objProductos[6]=new Producto("Cerveza Importada Erdinger", 850.0f, 0.5f);
		objProductos[7]=new Producto("Cerveza Importada Grolsch", 3200.0f, 1.0f);		
		
		//Productos que lanzan excepciones.
		objProductos[8]=new Producto("Caramelos Mediahora",0.0f,0.003f);
		objProductos[9]=new Producto("Papas",-520.5f,2.0f);
		
		
		//Objetos items carrito
		objItem[0] = new itemCarrito (objProductos[0],10);
		objItem[1] = new itemCarrito (objProductos[1],3);
		objItem[2] = new itemCarrito (objProductos[2],5);
		objItem[3] = new itemCarrito (objProductos[3],4);
		objItem[4] = new itemCarrito (objProductos[4],1);
		objItem[5] = new itemCarrito (objProductos[5],2);
		objItem[6] = new itemCarrito (objProductos[6],4);
		objItem[7] = new itemCarrito (objProductos[7],7);
		
		//Objetos que arrojan excepciones
		objItem[8] = new itemCarrito (objProductos[8],2);
		objItem[9] = new itemCarrito (objProductos[9],2);
		
		
		//Objetos carrito
		carrito1.add(objItem[0]);
		carrito1.add(objItem[1]);
		carrito1.add(objItem[2]);
		
		carrito2.add(objItem[6]);
		carrito2.add(objItem[7]);
		
		try {
			carrito3.add("./compra.dat");
		}
		catch(IOException e) {
			System.out.println("Archivo no encontrado");
		}
		
		//Objetos que arrojan excepciones
		carrito4.add(objItem[8]);
		carrito5.add(objItem[9]);		
		
		carrito3.precioTotal();
		
		//Imprime tickets.
		System.out.println("Precio carrito1: "+carrito1.precioTotal());
		System.out.println("Precio carrito2: "+carrito2.precioTotal());
		System.out.println("Precio carrito3: "+carrito3.precioTotal());
		
		try {
			carrito4.precioTotal(objDescuentoFijo);
		}		
		catch (NegativePriceException e){System.out.println(e.getClass().getSimpleName());

		}
		catch (NullPriceException f){System.out.println(f.getClass().getSimpleName());}
		
		
		//Ejemplo Captura Excepcion de precio negativo para este objeto
		try {
			carrito5.precioTotal(objDescuentoPorcentaje);
		}		
		catch (NegativePriceException e){System.out.println(e.getClass().getSimpleName());}
		catch (NullPriceException f){System.out.println(f.getClass().getSimpleName());}		
		
	}

}
