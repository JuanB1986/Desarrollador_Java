package com.Ejercicios_Clase7;

public class App 
{
    public static void main( String[] args )
    {    	
    	    
    	/****************************************************************************************************	
    	 Ejercicio Clase 7: Cambio el esquema de clases del ejercicio 5
    	    	1- Agrego el metodo getTipoDescuento() en clase Carrito para obtener el tipo de descuento y %.
    	  		2- Agrego la clase DescuentoPorcentajeConTope(float descuento) 
    	  		3- Agrego dos metodos test: para calcular el Precio total y el Peso total.    	 
    	*****************************************************************************************************/
    	
    	//Objetos
      	Producto 					objProductos[]=new Producto[10];
      	itemCarrito 				objItemCarrito[]=new itemCarrito[20];      	
      	DescuentoFijo 				objDescuentoFijo = new DescuentoFijo();
      	DescuentoPorcentaje			ojbDescuentoPorcentaje = new DescuentoPorcentaje(12.0f);
      	DescuentoPorcentajeConTope	objDescuentoPorcentajeConTope=new DescuentoPorcentajeConTope(13.5f);
        	
		//Objetos productos.
		objProductos[0]=new Producto("Manzana", 80.0f, 0.25f);
		objProductos[1]=new Producto("Peras", 68.0f, 0.3f);
		objProductos[2]=new Producto("Bananas", 56f, 0.2f);		
		objProductos[3]=new Producto("Pasta dental", 230.0f, 0.07f);
		objProductos[4]=new Producto("Cepillo de dientes", 350.0f, 0.05f);		
		objProductos[5]=new Producto("Cerveza Importada Hoegaarden", 230f, 0.5f);
		objProductos[6]=new Producto("Cerveza Importada Erdinger", 3100f, 1.5f);
		objProductos[7]=new Producto("Cerveza Importada Grolsch", 2800f, 1.5f);
		
		//Objetos itemsCarrito
		objItemCarrito[0]=new itemCarrito(objProductos[0], 4);
		objItemCarrito[1]=new itemCarrito(objProductos[7], 5);
		objItemCarrito[2]=new itemCarrito(objProductos[3], 2);
		objItemCarrito[3]=new itemCarrito(objProductos[6], 3);
		objItemCarrito[4]=new itemCarrito(objProductos[4], 2);
		objItemCarrito[5]=new itemCarrito(objProductos[2], 7);
		objItemCarrito[6]=new itemCarrito(objProductos[1], 5);
		objItemCarrito[7]=new itemCarrito(objProductos[5], 1);
		
		//Objetos Compras
      	Carrito compra1 = new Carrito("26/05/2022", objDescuentoFijo );
      	Carrito compra2 = new Carrito("04/06/2022", ojbDescuentoPorcentaje);      	
      	Carrito compra3 = new Carrito("19/08/2022", objDescuentoPorcentajeConTope);     
      	
      	//Carga objetos carritos
      	compra1.agregarItem(objItemCarrito[4]);
      	compra1.agregarItem(objItemCarrito[0]);
      	compra1.agregarItem(objItemCarrito[3]);
      	compra1.agregarItem(objItemCarrito[7]);
      	compra1.agregarItem(objItemCarrito[5]);
      	compra1.agregarItem(objItemCarrito[1]);		//Debe omitirse el agregado de este objeto (Maximo de items seteados = 5)
      	
      	compra2.agregarItem(objItemCarrito[2]);
      	compra2.agregarItem(objItemCarrito[6]);
      	compra2.agregarItem(objItemCarrito[1]);
      	
      	compra3.agregarItem(objItemCarrito[0]);
      	compra3.agregarItem(objItemCarrito[3]);
      	compra3.agregarItem(objItemCarrito[5]);
      	compra3.agregarItem(objItemCarrito[7]);      	
      	
      	//Imprime datos en pantalla
      	compra1.printTicket();
      	compra2.printTicket();
		compra3.printTicket();
	}
}
