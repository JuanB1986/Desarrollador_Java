package com.Ejercicio_Integrador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
  	
    	Alumno objAlumno[]=new Alumno[5];
    	
    	objAlumno[0] = new Alumno();
    	objAlumno[0].setNombre("Jose Rodriguez");
    	objAlumno[0].setLegajo("J-6955");
    	objAlumno[0].setMateriasAprobadas(null); 
    	
    	objAlumno[1] = new Alumno();
    	objAlumno[1].setNombre("Vanesa Sosa");
    	objAlumno[1].setLegajo("V-1589");
    	objAlumno[1].setMateriasAprobadas("Analisis Matematico 1");
    	objAlumno[1].setMateriasAprobadas("Informatica 1");
    	
    	objAlumno[2] = new Alumno();
    	objAlumno[2].setNombre("Lucia Perez");
    	objAlumno[2].setLegajo("L-1157");
    	objAlumno[2].setMateriasAprobadas(null);    	
    	
    	//Materias
    	Materia Analisis1 = new Materia("Analisis Matematico 1");
    	Materia Analisis2 = new Materia("Analisis Matematico 2");
    	Materia Fisica1 = new Materia("Fisica 1");
    	Materia Fisica2 = new Materia("Fisica 2");
    	Materia Fisica3 = new Materia("Fisica 3");

    	Analisis1.setCorrelativas(null);
    	Analisis2.setCorrelativas("Analisis Matematico 1");
    	Fisica1.setCorrelativas(null);
    	Fisica2.setCorrelativas("Fisica 1");
    	Fisica3.setCorrelativas("Fisica 2");

 	   	
    	//Lista de inscriptos
    	Inscripcion objInscriptos = new Inscripcion();    	
    
    	objInscriptos.setAlumno(objAlumno[0]);
    	objInscriptos.setAlumno(objAlumno[1]);
    	objInscriptos.setAlumno(objAlumno[2]);
    	objInscriptos.setMateria(Analisis1);
    	objInscriptos.setMateria(Analisis2);
    	objInscriptos.setMateria(Fisica1);
    	objInscriptos.setMateria(Fisica2);
    	objInscriptos.setMateria(Fisica3);
    	
    	   	
    	try {
    		objInscriptos.procesarInscripciones("./inscriptos.txt");
    	}catch(IOException e) {}	
    	 	
    	
    }
}
