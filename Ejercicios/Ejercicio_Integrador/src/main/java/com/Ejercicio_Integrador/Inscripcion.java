package com.Ejercicio_Integrador;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Inscripcion{

	private List<Alumno> listaAlumnos;
	private List<Materia> listaMaterias;

	
	public Inscripcion() {
		listaAlumnos = new ArrayList<Alumno>();
		listaMaterias = new ArrayList<Materia>();		
		
	}
	
	public void setAlumno(Alumno alumno) {
		this.listaAlumnos.add(alumno);
	}
	
	public void setMateria(Materia materia) {
		this.listaMaterias.add(materia);
	}
	
	private int indexAlumno(String nombre) {
		for (int i=0;i<this.listaAlumnos.size();++i) {
			if (this.listaAlumnos.get(i).getNombre().equals(nombre)) {
				return i;
			}
		}
		return -1;
	}
	
	private int indexMateria(String nombre) {
		for (int i=0;i<this.listaMaterias.size();++i) {
			if (this.listaMaterias.get(i).getNombre().equals(nombre)) {
				return i;
			}
		}
		return -1;
	}
	

	public void procesarInscripciones(String ruta) throws IOException {
		
		//Lee archivo de inscriptos.
		List<String> nombreAlumnoInscripto  = new ArrayList<String>();
		List<String> materiaAlumnoInscripto = new ArrayList<String>();		
		List<Integer> estadoInscripcion = new ArrayList<Integer>();
		
		String archivo = Files.readString(Paths.get(ruta));
		
		String separador[]=archivo.split(",");
		
		for (int i=0; i<separador.length/2;++i) {
			nombreAlumnoInscripto.add(separador[i*2].strip());
			materiaAlumnoInscripto.add(separador[(2*i)+1].strip());			
		}	
		
		int temp=0;
		
		//Busca alumno inscripto en la lista de alumnos
		for (int i=0; i<nombreAlumnoInscripto.size();++i) {
			temp=-1;
			for (int k=0;k < listaAlumnos.size();++k) {
				if (nombreAlumnoInscripto.get(i).equals(listaAlumnos.get(k).getNombre())) {
					temp=1;			
				}				 
			}
			estadoInscripcion.add(temp);				
		}
		

		//Busca materia en la que se anoto y guarda el puntero
		for (int i=0; i<nombreAlumnoInscripto.size();++i) {
			if(estadoInscripcion.get(i)==1) {
				temp=-2;
				for (int k=0;k < listaMaterias.size();++k) {
					if (materiaAlumnoInscripto.get(i).equals(listaMaterias.get(k).getNombre())) {
						temp=k;
					}
				}
				estadoInscripcion.set(i, temp);				
			}
		}

		//Busca si tiene materia correlativa aprobada
		for (int i=0; i<nombreAlumnoInscripto.size();++i) {	//recorre lista de inscriptos
			if(estadoInscripcion.get(i)>0) 
			{		
				temp=-3;
				int indiceAlumno = this.indexAlumno(nombreAlumnoInscripto.get(i));
				int indiceMateria = this.indexMateria(materiaAlumnoInscripto.get(i));				
					
				for (int j=0; j<listaAlumnos.get(indiceAlumno).getMateriasAprobadas().size();++j) 
				{
					String aprobada = listaAlumnos.get(indiceAlumno).getMateriasAprobadas().get(j);
					
					for (int k=0; k<listaMaterias.get(indiceMateria).getCorrelativas().size(); ++k)
					{
						String correlativa = listaMaterias.get(indiceMateria).getCorrelativas().get(k);
						
						if (correlativa==null) 
							{temp=1; break;}
						else {
							if (correlativa.equals(aprobada)) {temp=1;break;}
						}						
					}					
				}
				estadoInscripcion.set(i, temp);					
			}			
		}
		
		//Escribe archivo salida
		
		String lineaArchivo="";
		byte[] byteArray=null;
		
		for (int i=0; i<nombreAlumnoInscripto.size();++i) {
			
			lineaArchivo+= nombreAlumnoInscripto.get(i)+":		"+materiaAlumnoInscripto.get(i)+":		";
			
			switch(estadoInscripcion.get(i)) {
			case 1:
				lineaArchivo+= "Solicitud valida";
				break;
			case -1:
				lineaArchivo+= "El alumno no existe";
				break;
			case -2:
				lineaArchivo+= "La materia no existe";
				break;
			case -3:
				lineaArchivo+= "No tiene correlativa aprobada";
				break;
			}	
			lineaArchivo+="\n";
		}
		
		System.out.println(lineaArchivo);
		byteArray = lineaArchivo.getBytes();
		Files.write(Paths.get("./InscripcionesValidas.txt"), byteArray);				
		
	}	
}

