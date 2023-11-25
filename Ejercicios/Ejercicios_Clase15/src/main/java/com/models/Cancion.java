package com.models;

import lombok.Getter;

public class Cancion {
	
	private String nombre;
	private String autor;
	private String album;
	private int year;
	private Icono icono; 
	@Getter private Popularidad popularidad;
		
	public Cancion(String nombre, String autor, String album, int year) {
		this.nombre=nombre;
		this.album=album;
		this.autor=autor;	
		this.year=year;		
		this.popularidad=new Popularidad();
		this.icono=this.popularidad.getPopularidad();
	}
	
	public void setReproducciones(int reproducciones) {
		this.popularidad.setReproducciones(reproducciones);
		this.icono=this.popularidad.getPopularidad();
	}
	
	public void setLikes(int likes) {
		this.popularidad.setLikes(likes);				
		this.icono=this.popularidad.getPopularidad();
	}
	
	public void setDislikes(int Dislikes) {
		this.popularidad.setDislikes(Dislikes);
		this.icono=this.popularidad.getPopularidad();
	}
	
	public void setHsSinReproducir(int hs) {
		this.popularidad.setHsSinReproducir(hs);
		this.icono=this.popularidad.getPopularidad();
	}
		
	public String display() {
		return this.icono.decode()+" "+this.nombre+" - "+this.autor+" ("+this.album+" - "+this.year+")";
	}
	
	
}
