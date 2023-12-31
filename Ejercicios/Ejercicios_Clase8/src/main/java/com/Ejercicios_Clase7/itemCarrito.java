package com.Ejercicios_Clase7;

import com.Ejercicios_Clase7.Excepciones.NegativePriceException;
import com.Ejercicios_Clase7.Excepciones.NullPriceException;

public class itemCarrito {
	
	private Producto producto;
	private int cantidad;
	
	
	public itemCarrito() {
		
	}
	
	public itemCarrito (Producto producto , int cantidad) {
		
		this.cantidad=cantidad;
		this.producto=producto;		
	}
	
	public Producto getProducto() {
		return this.producto;
	}
	
	public float getPrecio() throws NullPriceException, NegativePriceException {
		return this.producto.getPrecio();
	}
	
	public float getPeso() {
		return this.producto.getPeso();
	}
	
	public String getDescripcion() {
		return this.producto.getDescripcion();
	}
	
	public int getCantidad() {
		return this.cantidad;
	}	
	
	/******************************/
	
	public void setPrecio(float precio) {
		this.producto.setPrecio(precio);
	}
	
	public void setPeso(float peso) {
		this.producto.setPeso(peso);
	}
	
	public void setDescripcion(String descripcion) {
		this.producto.setDescripcion(descripcion);
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}
	
	public void setProducto(Producto producto) {
		this.producto=producto;
	}
	
	

}
