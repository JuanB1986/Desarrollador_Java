package Ejercicios;

public class Ejercicio1B {	

		public static void main(String[] args) {
			
			int vector[]=new int[3];
			boolean orden=true;			//false: Desendente
			int i,j,buffer;
			
			vector[0]=56;
			vector[1]=5;
			vector[2]=76;		
			
			for (j=0;j<vector.length;++j)
			{
				for (i=0;i<vector.length-1;++i)
				{
					if (!orden)
					{
						if (vector[i+1]>vector[i]) //Orden descendente
						{
							buffer = vector[i]; 
							vector[i] = vector[i+1];
							vector[i+1]=buffer;
						}
					}
					else
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

