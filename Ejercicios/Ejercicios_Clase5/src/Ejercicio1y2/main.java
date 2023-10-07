package Ejercicio1y2;

public class main {

	public static void main(String[] args) {
		
		//Objetos productos
		ComboProductos producto1=new ComboProductos(3);
		ComboProductos producto2=new ComboProductos(2);
		ComboProductos producto3=new ComboProductos(3);
		
		//Objetos Compras
		Carrito compra1=new Carrito();
		Carrito compra2=new Carrito();
		Carrito compra3=new Carrito("./compra1.dat");

		//Objetos Descuentos
		DescuentoFijo objDesFijo = new DescuentoFijo();
		DescuentoVar objDescVar = new DescuentoVar(0.25f);		
		
		//Carga Combo de productos.
		producto1.cargarProductos("Manzana", 150.2f, 1, 0);
		producto1.cargarProductos("Peras", 102f, 1, 1);
		producto1.cargarProductos("Bananas", 110f, 1, 2);
		
		producto2.cargarProductos("Pasta dental", 55, 0.1f, 0);
		producto2.cargarProductos("Cepillo de dientes", 35, 0.05f, 1);
		
		producto3.cargarProductos("Cerveza Importada Hoegaarden", 230f, 0.5f, 0);
		producto3.cargarProductos("Cerveza Importada Erdinger", 310f, 0.5f, 1);
		producto3.cargarProductos("Cerveza Importada Grolsch", 280f, 0.5f, 2);
		
		
		//Compras
		compra1.agregarProducto(producto3);
		compra1.agregarProducto(producto1);
		compra1.computoTotales(objDesFijo);
		
		compra2.agregarProducto(producto2);
		compra2.agregarProducto(producto2);
		compra2.agregarProducto(producto1);
		compra2.computoTotales(objDescVar);
		
		compra3.computoTotales(objDesFijo);		
	
		//Imprime tickets.
		compra1.imprimirTicket();
		compra2.imprimirTicket();
		compra3.imprimirTicket();
		
		
	}

}
