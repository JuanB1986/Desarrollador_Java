package Ejercicio1y2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;

public class Carrito {
	
	//Variables
	private float totalPrecioDescuento;
	private float totalPrecio; 
	private float totalPeso;
	private ComboProductos prodCompra[];
	private int ptr;
	private final int cantMaximaProd=100;
	private String ruta;
	private boolean constructor;
	private int longLista;
	private String descripcion[];
	private float  precio[];
	private float  peso[];
	
	
	//Constructor 
	public Carrito() {
		this.prodCompra=new ComboProductos [cantMaximaProd];
		this.ptr=0;
		this.constructor=false;
	}
	
	
	//Constructor sobrecargado: Añado ruta para leer archivo de base de datos de compra
	public Carrito(String ruta) {
		this.ruta=ruta;
		this.ptr=0;
		this.constructor=true;
		this.descripcion=new String [cantMaximaProd];
		this.precio=new float[cantMaximaProd];
		this.peso=new float [cantMaximaProd];
	}
	
	
	//Método agregar producto
	public void agregarProducto(ComboProductos producto) {
		if (this.ptr<this.cantMaximaProd) {
			this.prodCompra[ptr++]=producto;
		}
		else
		{
			System.out.print("Máximo de productos alcanzado");
		}
	}
	
		
	
	//Método computo precio
	public void computoTotales(Descuento objDescIn) 
	{
		Descuento objDesc=new Descuento();
		objDesc=objDescIn;
		
		if(!this.constructor) {
			this.totalPeso=0.0f;
			this.totalPrecio=0.0f;
			
			int i,j;
			for (i=0;i<this.ptr;++i) {
				for (j=0;j<this.prodCompra[i].getTotalItems();++j) {
					this.totalPrecio += this.prodCompra[i].getPrecio(j);
					this.totalPeso += this.prodCompra[i].getPeso(j);
				}			
			}				
		}
		else 
		{
			String separador[];
			String file=null;
			int i;	
			
			try {
				file = Files.readString(Paths.get(ruta));
			}
			catch(IOException e) {}		
			
			separador = file.split(",");
			this.longLista = separador.length/3;
			
			for (i=0;i<separador.length/3;++i) {
				this.descripcion[i]=separador[i*3].toString();
				this.precio[i]=Float.parseFloat(separador[3*i+1].strip());			
				this.peso[i]=Float.parseFloat(separador[3*i+2].strip());				
			}
			
			this.totalPeso=0.0f;
			this.totalPrecio=0.0f;
			
			for (i=0;i<separador.length/3;++i) {
				this.totalPrecio += precio[i];
				this.totalPeso += peso[i];				
			}			
		}
		
		totalPrecioDescuento = totalPrecio - totalPrecio*objDesc.getDescuento();
	}
	
	
	
	//Métodos get precios
	public float getPrecioTotal() {return this.totalPrecio;}
	
	public float getPesoTotal() {return this.totalPeso;}	
	
	
	//Método imprimir ticket.
	public void imprimirTicket() {
		int i,j;
		System.out.println("********************TICKET********************");
		
		if (!constructor) {
			for (i=0;i<this.ptr;++i) {
				for (j=0;j<this.prodCompra[i].getTotalItems();++j) {
					System.out.println(prodCompra[i].getDescripcion(j)+ "	$: "+prodCompra[i].getPrecio(j)+" 	Kg: "+prodCompra[i].getPeso(j));
				}			
			}				
		}
		else
		{
			for (i=0;i<this.longLista;++i) {
				System.out.print(this.descripcion[i]+" 	$: "+this.precio[i]+" 	Kg: "+this.peso[i]);				
			}
		}
		System.out.print("\n");
		System.out.println("-----------------------------------------------");
		System.out.println("Total $:	"+this.totalPrecio);
		System.out.println("Total con Descuento $:	"+this.totalPrecioDescuento);
		System.out.println("Total Kg:	"+this.totalPeso);
		System.out.println("**********************************************");
		System.out.print("\n\n");		
	}
}
