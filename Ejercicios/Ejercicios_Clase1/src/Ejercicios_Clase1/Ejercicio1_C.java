package Ejercicios_Clase1;


public class Ejercicio1_C {

	public static void main(String[] args) {
		int numInicio=5;
		int numFin=14;
		int contador=0;
		boolean parImparFLAG=true;
		
		contador=numInicio;
		
		while ( contador <= numFin) 
		{
			if ( (contador % 2)==0 && parImparFLAG==true)
				{
					System.out.println(contador);
				}
			
			if ( (contador % 2)>0 && parImparFLAG==false)
				{
					System.out.println(contador);
				}
			
			
			++contador;
		}		
		
	}

}