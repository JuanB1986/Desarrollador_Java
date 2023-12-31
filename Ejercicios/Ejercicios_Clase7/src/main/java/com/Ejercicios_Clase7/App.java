package com.Ejercicios_Clase7;


public class App {

	public static void main(String[] args) {		
		
    	/****************************************************************************************************	
   	 	Ejercicio Clase 7: Cambie el esquema de clases del ejercicio 5. (No use la clase itemCarrito).
   	 	
   	    	1- Agrego el metodo getTipoDescuento() en clase Carrito para obtener el tipo de descuento y %.
   	    Dentro del metodo calcularPrecioTotal() se escribe la variable que devuelve el metodo getTipoDescuento()
   	  		2- Agrego la clase DescuentoPorcentajeConTope(float descuento) 
   	  		3- Agrego metodos test en CarritoTest.java 	 
    	*****************************************************************************************************/
		
		//Objetos productos
		Producto objProductos[]=new Producto[20]; 
		
		//Objetos Compras
		Carrito compra1=new Carrito();
		Carrito compra2=new Carrito();
		Carrito compra3=new Carrito("./compra.dat");

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
				
		//Compras
		compra1.agregarProducto(objProductos[0],6);
		compra1.agregarProducto(objProductos[3],2);
		compra1.agregarProducto(objProductos[4],3);
		compra1.agregarProducto(objProductos[7],3);
		
		compra2.agregarProducto(objProductos[2],2);
		compra2.agregarProducto(objProductos[1],4);
		compra2.agregarProducto(objProductos[0],5);
		
		compra1.calcularPrecioTotal(objDescuentoPorcentaje);	
		compra2.calcularPrecioTotal(objDecuentoConTope);		
		compra3.calcularPrecioTotal(objDescuentoFijo);		

		//Imprime tickets.
		compra1.imprimirTicket();
		compra2.imprimirTicket();
		compra3.imprimirTicket();	
			
	}

}
