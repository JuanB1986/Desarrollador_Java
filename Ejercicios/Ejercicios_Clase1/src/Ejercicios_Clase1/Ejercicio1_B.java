package Ejercicios_Clase1;


public class Ejercicio1_B {

	public static void main(String[] args) {
		int numInicio=5;
		int numFin=14;
		int contador=0;
		
		contador=numInicio;
		
		while ( contador <= numFin) 
		{
			if ( (contador % 2)==0 )
				{
					System.out.println(contador);			
				}
			
			++contador;
		}		
		
	}

}