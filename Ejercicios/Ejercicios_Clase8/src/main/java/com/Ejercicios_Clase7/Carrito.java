package com.Ejercicios_Clase7;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.Ejercicios_Clase7.Excepciones.NegativePriceException;
import com.Ejercicios_Clase7.Excepciones.NullPriceException;

import java.io.IOException;


public class Carrito {
	
	//Variables
	private List<itemCarrito> listaProductos;
	private String file;
	
	//Constructor 
	public Carrito() {		
		listaProductos=new ArrayList<itemCarrito>();
	}	

	//Nuevo metodo add
	public void add(itemCarrito item) {
		this.listaProductos.add(item);
	}
	
	public void add(String descripcion, float precio, float peso, int cantidad) {
		Producto prod1=new Producto();
		itemCarrito item1=new itemCarrito(prod1,0);	
		
		item1.setDescripcion(descripcion);
		item1.setPrecio(precio);
		item1.setPeso(peso);
		item1.setCantidad(cantidad);
		
		this.listaProductos.add(item1);
	}
	
	public void add(String archivoRuta) throws NullPriceException, NegativePriceException,IOException
	{
		String descripcion;
		float  precio;
		float  peso;
		int i, cantidadProductos;	
		String separador[];
		final int CANT_PARAMETROS_POR_LINEA=4;
				
		file = Files.readString(Paths.get(archivoRuta));				
		
		separador = file.split(",");
		
		for (i=0;i<separador.length/CANT_PARAMETROS_POR_LINEA;++i) 
		{		
			descripcion=separador[i*CANT_PARAMETROS_POR_LINEA].toString();
			precio=Float.parseFloat(separador[CANT_PARAMETROS_POR_LINEA*i+1].strip());			
			peso=Float.parseFloat(separador[CANT_PARAMETROS_POR_LINEA*i+2].strip());	
			cantidadProductos=Integer.parseInt(separador[CANT_PARAMETROS_POR_LINEA*i+3].strip());	
			
			this.add(descripcion, precio, peso, cantidadProductos);			
		}			
	}		
	
	public void remove(itemCarrito item) {
		this.listaProductos.remove(item);
	}
	
	public double getPesoTotal() {		
		int i;
		double peso=0.0;
		
		for (i=0; i<listaProductos.size();++i) {
			peso +=listaProductos.get(i).getPeso() * listaProductos.get(i).getCantidad();			
		}
		return peso;	
		
	}	
	
	public double precioTotal() throws NullPriceException, NegativePriceException {
		int i;
		double precio=0.0;		
		for (i=0; i<listaProductos.size();++i) {
			precio += listaProductos.get(i).getPrecio() * listaProductos.get(i).getCantidad();
		}
		return precio;	
	}
	
	
	public double precioTotal(Descuento descuento ) throws NullPriceException, NegativePriceException {
		int i;
		double precio=0.0;
		for (i=0; i<listaProductos.size();++i) {
			precio +=listaProductos.get(i).getPrecio()* listaProductos.get(i).getCantidad();
		}
		return precio-(precio*descuento.getDescuento()/100.0f);	
	}
}	
