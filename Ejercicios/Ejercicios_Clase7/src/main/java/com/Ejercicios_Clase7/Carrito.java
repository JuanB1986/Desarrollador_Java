package com.Ejercicios_Clase7;

public class  Carrito {
	private final int MaximoItems=5;
	private String fecha;
	private itemCarrito []items;
	private int contadorItems;		
	private Descuento descuento;
	
	//Constructor
	public Carrito(String fecha, Descuento descuento) {
		this.fecha=fecha;
		this.descuento=descuento;
		this.items=new itemCarrito[this.MaximoItems];
	}
	
	//Metodo agregar items
	public void agregarItem(itemCarrito item) {		
		if (this.contadorItems < this.MaximoItems)
			{
				this.items[contadorItems++]=item;
			}
		else
		{
			System.out.println("Máximo de items alcanzado");
		}
	}
	
	//Metodo computo precio total
	public float getPrecioTotal() {
		int i;
		float retval=0;
		
		for (i=0;i<this.contadorItems;++i) {
			retval += this.items[i].getPrecio();
		}		
		
		retval -= retval*this.descuento.getDescuento()/100.0f;
		
		return retval;
	}	
	
	//Metodo computo peso total
	public float getPesoTotal() {
		int i;
		float retval=0;
		
		for (i=0;i<this.contadorItems;++i) {
			retval += this.items[i].getPeso();
		}		
		return retval;
	}
	
	//Imprime descuento y tipo
	public String getTipoDescuento() {		
		return this.descuento.getClass().getSimpleName() + ": " + this.descuento.getDescuento() + " %";		
	}
	
	//Metodo Imprime ticket
	public void printTicket() {
		
		System.out.println("------------------------------------------------");
		System.out.println("Precio Total $: " + this.getPrecioTotal() );
		System.out.println("Peso Total $: " + this.getPesoTotal()+" Kg" );
		System.out.println("Tipo descuento: "+this.getTipoDescuento());
		System.out.println("------------------------------------------------");
	}
	
}
