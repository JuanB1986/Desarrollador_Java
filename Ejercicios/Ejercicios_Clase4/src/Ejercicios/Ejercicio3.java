package Ejercicios;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;


public class Ejercicio3 
{
	/***************************************************************
	Función: Codificación de texto
	****************************************************************/
	private static String codificador(String texto, int desplaCaracter, char codec) {

		byte byteTemp;
		String texto2="";
		int i;
		
		for (i=0;i<texto.length();++i)
		{		
			byteTemp = (byte)texto.charAt(i);
			if (codec=='c') {
				byteTemp += desplaCaracter;				//Siguente Caracter
			}
			if (codec=='d') {
				byteTemp -= desplaCaracter;
			}
			texto2 = texto2 + (char)byteTemp;
		}

		return texto2;
	}	
	
	/***************************************************************
	Main Program.
	****************************************************************/	
	public static void main(String[] args) throws IOException 
	{
		
		String texto="",texto2="",txtSalida="",pathIn,pathOut;
		String split[];
		int i;
		byte desplaza;													
		char codec;
		
		List lista;
		Files archivoIn = null;
		Files archivoOut = null;		
		
		//Entrada de parametros desde main.
		pathIn = args[0].toString().strip();
		pathOut = args[1].toString().strip();	
		desplaza=(byte) Integer.parseInt(args[2].strip());	
		codec=args[3].charAt(0);
		
		
		lista = archivoIn.readAllLines(Paths.get(pathIn));
			
		byte bytesOut[];
		for(i=0;i<lista.size();++i)
		{
			texto=lista.get(i).toString();
			texto2=codificador(texto,desplaza,codec);			
			txtSalida+= texto2+"\n";											//arma el archivo de salida en string.	
		}	
		bytesOut=txtSalida.getBytes();											//paso el archivo a array de byte
		archivoOut.write(Paths.get(pathOut),bytesOut );		//escribe archivo.
		
		System.out.print("Finalizado");
		
	}
}
