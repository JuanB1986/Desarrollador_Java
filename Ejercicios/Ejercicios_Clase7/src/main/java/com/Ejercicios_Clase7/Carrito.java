package com.Ejercicios_Clase7;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;


public class Carrito {
	
	//Variables
	private final int MAXIMO_PRODUCTOS=100;
	private float totalPrecioDescuento;
	private float totalPrecio; 
	private float totalPeso;
	private Producto objProductos[];
	private int cantidadProductos[];
	private int punteroProductos;
	private boolean tipoConstructor;

	private String tipoDescuento;
	
	//Variables para manejo de archivos
	private String archivoRuta;
	private int archivoLongitudLista;
	private String descripcion[];
	private float  precio[];
	private float  peso[];
	private int archivoCantidadProductos[];	
	
	//Constructor 
	public Carrito() {
		this.objProductos=new Producto [MAXIMO_PRODUCTOS];
		this.cantidadProductos=new int [MAXIMO_PRODUCTOS];
		this.punteroProductos=0;
		this.tipoConstructor=false;
	}
	
	
	//Constructor sobrecargado: Añado ruta para leer archivo de base de datos de compra
	public Carrito(String ruta) {
		this.archivoRuta=ruta;
		this.punteroProductos=0;
		this.tipoConstructor=true;
		this.descripcion=new String [MAXIMO_PRODUCTOS];
		this.precio=new float[MAXIMO_PRODUCTOS];
		this.peso=new float [MAXIMO_PRODUCTOS];
		this.cantidadProductos=new int [MAXIMO_PRODUCTOS];
		this.archivoCantidadProductos=new int [MAXIMO_PRODUCTOS];
	}
	
	
	//Método agregar producto
	public void agregarProducto(Producto items, int cantidad) {
		if (this.punteroProductos<this.MAXIMO_PRODUCTOS) {
			this.objProductos[this.punteroProductos]=items;
			this.cantidadProductos[this.punteroProductos]=cantidad;
			this.punteroProductos++;
		}
		else
		{
			System.out.print("Máximo de productos alcanzado");
		}
	}
	
	
	//Metodo obtener tipo y descuento
	public String getTipoDescuento() {
		return tipoDescuento;
	}
		
	
	//Método computo precio
	public void calcularPrecioTotal(Descuento objDescuento) 
	{	int i;
		Descuento objDesc;
		objDesc=objDescuento;
		
		
		tipoDescuento = objDesc.getClass().getSimpleName() + ": " + objDesc.getDescuento() + " %";
		
		if(!this.tipoConstructor) {
			this.totalPeso=0.0f;
			this.totalPrecio=0.0f;
			
			for (i=0;i<this.punteroProductos;++i) {				
				this.totalPrecio += this.objProductos[i].getPrecio()*this.cantidadProductos[i];
				this.totalPeso += this.objProductos[i].getPeso()*this.cantidadProductos[i];		
			}				
		}
		else 
		{
			String separador[];
			String file=null;
			final int CANT_PARAMETROS_POR_LINEA=4;
			
			try {
				file = Files.readString(Paths.get(archivoRuta));
			}
			catch(IOException e) {}		
			
			separador = file.split(",");
			this.archivoLongitudLista = separador.length/CANT_PARAMETROS_POR_LINEA;
			
			for (i=0;i<separador.length/CANT_PARAMETROS_POR_LINEA;++i) {
				this.descripcion[i]=separador[i*CANT_PARAMETROS_POR_LINEA].toString();
				this.precio[i]=Float.parseFloat(separador[CANT_PARAMETROS_POR_LINEA*i+1].strip());			
				this.peso[i]=Float.parseFloat(separador[CANT_PARAMETROS_POR_LINEA*i+2].strip());	
				this.archivoCantidadProductos[i]=Integer.parseInt(separador[CANT_PARAMETROS_POR_LINEA*i+3].strip());
			}
			
			this.totalPeso=0.0f;
			this.totalPrecio=0.0f;
			
			for (i=0;i<separador.length/CANT_PARAMETROS_POR_LINEA;++i) {
				this.totalPrecio += this.precio[i]*this.archivoCantidadProductos[i];
				this.totalPeso += this.peso[i]*this.archivoCantidadProductos[i];				
			}			
		}
		totalPrecioDescuento =totalPrecio- totalPrecio*objDesc.getDescuento()/100.0f;
	}
	
	
	//Métodos get precios descuento
	public float getPrecioTotalDescuento(){
			return this.totalPrecioDescuento;
	}	
	
	//Métodos get precios
	public float getPrecioTotal(){
			return this.totalPrecio;
	}	
	
	//Métodos get peso
	public float getPesoTotal() {
		return this.totalPeso;
	}	
	
	
	//Método imprimir ticket.
	public void imprimirTicket() {
		int i;
		System.out.println("********************TICKET********************");
		
		if (!tipoConstructor) {
			for (i=0;i<this.punteroProductos;++i) {
				System.out.println( "Item("+(i+1)+") "+this.objProductos[i].getDescripcion()+ " ($ "+this.objProductos[i].getPrecio()+" - "+this.objProductos[i].getPeso()+" Kg.)  X "+this.cantidadProductos[i]+" Unidades");
			}				
		}
		else
		{
			for (i=0;i<this.archivoLongitudLista;++i) {
				System.out.println( "Item("+(i+1)+") "+this.descripcion[i].strip() + " ($ "+this.precio[i]+" - "+this.peso[i]+" Kg.)  X "+this.archivoCantidadProductos[i]+" Unidades");
			}
		}
		System.out.print("\n");
		System.out.println("-----------------------------------------------");
		System.out.println("Total     $: "+this.totalPrecio);
		System.out.println("Total Dto $: "+this.totalPrecioDescuento);
		System.out.println("Total Kg: "+this.totalPeso);
		System.out.println("Tipo descuento: "+ this.getTipoDescuento());
		System.out.println("**********************************************");
		System.out.print("\n\n");		
	}
}
