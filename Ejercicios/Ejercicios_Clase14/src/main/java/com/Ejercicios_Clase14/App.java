package com.Ejercicios_Clase14;

import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class App 
{
    public static void main( String[] args )
    {

     	Scanner scan = new Scanner (System.in);      	

     	Path ruta = Paths.get("./Recursos/Swap.txt");
     	
     	System.out.println("Ingrese su nombre: ");
     	     	
     	String nombre= scan.nextLine();
     	
     	while (true) {
     	
	     	System.out.println("1- Escribir mensaje \n2- Leer mensajes\n");	     	
	     	String menu = scan.nextLine();
	     	
		   	if (menu.equals("1")) {
		     	
		    	try {		    		
		    		String archivo = Files.readString(ruta);		    		
		    		String leeLinea = scan.nextLine();	    	
		    		archivo += "\n<"+nombre+"> "+leeLinea;		 
		    		byte write[] = archivo.getBytes();
		    		Files.write(ruta, write);			    	
		    	}
		    	catch(FileNotFoundException e) {}
		    	catch (IOException i) {}
	     	}
	    	
		   	if (menu.equals("2")) {
		     	
		    	try {		    		
		    		System.out.println(Files.readString(ruta));
		    	}
		    	catch(FileNotFoundException e) {}
		    	catch (IOException i) {}
	     	}     	
     	}   	
    }
}
