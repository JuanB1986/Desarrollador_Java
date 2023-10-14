package com.Ejercicios_Clase7;

public class itemCarrito {

		private int cantidad;
		private Producto producto;		

		public itemCarrito( Producto producto, int cantidad) {
			this.cantidad=cantidad;
			this.producto=producto;
		}
		
		public void setCantidad(int cantidad) {
			this.cantidad=cantidad;
		}
		
		public int getCantidad() {
			return this.cantidad;
		}
		
		public String getDescripcion() {
			return this.producto.getDescripcion();
		}
		
		public float getPrecio() {
			return this.producto.getPrecio()*this.cantidad;
		}
		
		public float getPeso() {
			return this.producto.getPeso()*this.cantidad;
		}
		
}

