package Ejercicios;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Paths;

public class Ejercicio2 {

	public static void main(String[] args) throws IOException {
		
		Files archivo = null;
		int i,acumulador;		
		String fileLine;
		String split[];		
		
		//Pasaje de parametros desde el main.
		String filePath= args[0].toString().strip();			//Ruta relativa al proyecto: 	"./archivo_ej2/numeros.n"; 
		char operacion=args[1].charAt(0);
		
			
		fileLine = archivo.readString(Paths.get(filePath));		//En fileLine se lee todo el archivo.
			
		split=fileLine.split("\n");								//Divide ek archivo por el salto de línea.
		
		i=Integer.parseInt(split[0].strip());					//Strip, remueve espacios iniciales y finales. Quita el Carriage Return ASCII (13).
			
		acumulador=Integer.parseInt(split[0].strip());
		
		for (i=1;i<split.length;++i)
		{
			if (operacion=='+') 
			{
				acumulador += Integer.parseInt(split[i].strip());			
			}
			
			if (operacion=='x')
			{
				acumulador *= Integer.parseInt(split[i].strip()); 
			}
		}
		
		System.out.print("El resultado de la ("+operacion+") es: "+acumulador);		
		
	}

}
