package Ejercicios;


public class Ejercicio1A {

	public static void main(String[] args) {
		
		String texto="Juan Manuel Banquero";
		char letra='n';
		int i,cont=0;
		
		for (i=0;i<texto.length();++i)
		{
			if (letra== texto.charAt(i))
			{++cont;}
		}
		System.out.println("La cantidad letras: '"+letra+"', es: "+cont);		

	}

}
