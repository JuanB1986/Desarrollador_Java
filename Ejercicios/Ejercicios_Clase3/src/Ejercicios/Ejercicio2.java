package Ejercicios;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		String texto,texto2;
		int i;
		byte byteTemp;
		byte desplaCaracter;
		
		//Inicio variables
		texto="curso programador java";				// Texto  a codificar
		texto2="";	
		desplaCaracter=2;							// Cantidad de desplazamientos deseados.
				
		for (i=0;i<texto.length();++i)
		{		
			byteTemp = (byte)texto.charAt(i);
			byteTemp += desplaCaracter;							//Siguente Caracter
			texto2 = texto2 + (char)byteTemp;
		}
		
		System.out.println("Texto Codificado: " + texto2);
		
	}

}
