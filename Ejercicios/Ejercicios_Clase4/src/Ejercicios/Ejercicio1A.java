package Ejercicios;

public class Ejercicio1A {

	public static void main(String[] args) {

		int vector[]=new int[3];
		char orden;						
		int i,j,buffer;
		
		
		//Paso de argumentos desde el main		
		vector[0]=Integer.parseInt(args[0].strip());
		vector[1]=Integer.parseInt(args[1].strip());
		vector[2]=Integer.parseInt(args[2].strip());
		orden=args[3].charAt(0);			

		
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
