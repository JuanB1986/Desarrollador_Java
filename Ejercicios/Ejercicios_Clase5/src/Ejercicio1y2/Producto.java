package Ejercicio1y2;


public class Producto {

	private String descripcion;
	private float precio;
	private float peso;
	
	public Producto(String descripcion, float precio, float peso)
	{
		this.descripcion=descripcion;
		this.precio=precio;
		this.peso=peso;		
	}

	public float getPrecio() {
		return this.precio;
	}
	
	public float getPeso() {
		return this.peso;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
}
