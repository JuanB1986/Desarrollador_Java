package com.Ejercicios_Clase7;


public class DescuentoFijo extends Descuento{

		private final float descuento=5.0f;
		
		public DescuentoFijo() {
			super();
		}
		
		public float getDescuento() {
			return this.descuento;
		}
}
