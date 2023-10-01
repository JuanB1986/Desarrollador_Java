package Ejercicios;

import java.util.Scanner;

public class Ejercicio1C {

	/***************************************************************
	Función: Ordena vector.
	****************************************************************/
	private static int []vectorSort(int inVector[], char orden)
	{
		int []vector=new int [3];
		int i,j,buffer;
		
		vector=inVector;
		
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
		
		return vector;
	}
	
	
	/***************************************************************
	Main Program.
	****************************************************************/	
	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		int inVector[]=new int[3];
		int outVector[]=new int[3];
		char orden;						
		int i,j,buffer;
		
		
		if (args.length==0)
		{		
			//Entrada por teclado
			System.out.print("Ingrese el Nº1: ");
			inVector[0]=entrada.nextInt();
			System.out.print("Ingrese el Nº2: ");
			inVector[1]=entrada.nextInt();
			System.out.print("Ingrese el Nº3: ");
			inVector[2]=entrada.nextInt();	
			System.out.print("Ingrese el orden (a/d): ");
			orden=entrada.next().charAt(0);		
		}
		else
		{
			//Entrada de parámetros desde el main.
			inVector[0]=Integer.parseInt(args[0].strip());
			inVector[1]=Integer.parseInt(args[1].strip());
			inVector[2]=Integer.parseInt(args[2].strip());
			orden = args[3].charAt(0);	
		}
			
		
		//Call: funcion de ordenamiento de vector.	
		outVector=vectorSort(inVector,orden);		
				
		
		for (i=0;i<inVector.length;++i)
		{
			System.out.println(outVector[i]);
		}
	}
}






