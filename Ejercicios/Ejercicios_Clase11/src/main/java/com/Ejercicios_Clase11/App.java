package com.Ejercicios_Clase11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {    
    	List<Persona> listaPersona = new ArrayList<Persona>();
        Persona objPersonas;
        Scanner objIngreso=new Scanner(System.in);
      
        int opcion=0;
        do {
        	System.out.println("0- Salir");
        	System.out.println("1- Ingresar datos");
        	System.out.println("2- Imprimir datos");
        	opcion = Integer.parseInt(objIngreso.nextLine());
        	
        	switch(opcion) {
        	case 0:
        		break;
        	case 1:
        		objPersonas = new Persona();
        		
		        System.out.println("Ingrese Nombre y Apellido");
		        objPersonas.setNombre(objIngreso.nextLine());
		        
		        System.out.println("Ingrese Fecha de nacimeinto");
		        objPersonas.setFecha(objIngreso.nextLine());		        
		        
		        listaPersona.add(objPersonas);		        
		        
		        break;
        	case 2:        		
        		if (listaPersona.size()==0) {
        			System.out.println("Lista Vacia");
        		}
        		else
        		{
        			for (int i=0; i < listaPersona.size(); ++i) {
        				System.out.println(listaPersona.get(i).getNombre()+", "+listaPersona.get(i).getFecha());        				
        			}
        		}
        		break;
        	}       
        
        }while(opcion>0);
        
        objIngreso.close();
    }
}
