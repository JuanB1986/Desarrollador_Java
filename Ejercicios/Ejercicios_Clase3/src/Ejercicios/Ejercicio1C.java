package Ejercicios;

public class Ejercicio1C {
	
	public static void main(String[] args) {
		int vector[]=new int[20];
		int numeroX=13;
		int acumulador=0;
		int i;
		
		
		//Lleno el array con numeros.
		for (i=0;i<vector.length;++i)
		{
			vector[i]=i;
		}
		
		//Suma		
		for (i=0;i<vector.length;++i)
		{
			if (vector[i] > numeroX)
			{
				acumulador += vector[i];
			}
		}
		
		//Muestra
		System.out.println("Resultado: " + acumulador);		

	}
}
