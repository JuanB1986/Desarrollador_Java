package Ejercicios;
import java.util.Scanner;

public class Ejercicio1B {

	public static void main(String[] args) {

		Scanner entrada=new Scanner(System.in);
		int vector[]=new int[3];
		char orden;						
		int i,j,buffer;
		
		
		//Entrada por teclado
		System.out.print("Ingrese el Nº1: ");
		vector[0]=entrada.nextInt();
		System.out.print("Ingrese el Nº2: ");
		vector[1]=entrada.nextInt();
		System.out.print("Ingrese el Nº3: ");
		vector[2]=entrada.nextInt();	
		System.out.print("Ingrese el orden (a/d): ");
		orden=entrada.next().charAt(0);
		
		for (j=0;j<vector.length;++j)
		{
			for (i=0;i<vector.length-1;++i)
			{
				if (orden=='d')
				{
					if (vector[i+1]>vector[i]) //Orden descendente
					{
						buffer = vector[i]; 
						vector[i] = vector[i+1];
						vector[i+1]=buffer;
					}
				}
				if (orden=='a')
				{
					if (vector[i+1] < vector[i]) //Orden ascendente
					{
						buffer = vector[i]; 
						vector[i] = vector[i+1];
						vector[i+1]=buffer;
					}
					
				}
			}
		}
		
		for (i=0;i<vector.length;++i)
		{
			System.out.println(vector[i]);
		}	
		
		

	}

}
