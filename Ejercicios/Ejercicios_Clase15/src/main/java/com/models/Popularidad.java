package com.models;

import com.states.Auge;
import com.states.Estado;
import com.states.Normal;
import com.states.Tendencia;

import lombok.Getter;
import lombok.Setter;

public class Popularidad {
	
	private Icono MUSICAL_NOTE 	= new Icono(new byte[]{(byte)0xf0, (byte)0x9f, (byte)0x8e, (byte)0xB5});
	private Icono ROCKET 		= new Icono(new byte[]{(byte)0xf0, (byte)0x9f, (byte)0x9a, (byte)0x80});    		
	private Icono FIRE 			= new Icono(new byte[]{(byte)0xf0, (byte)0x9f, (byte)0x94, (byte)0xa5});  
	
	@Setter @Getter private int likes;
	@Setter @Getter private int dislikes;
	@Setter @Getter private int reproducciones;	
	@Setter @Getter private int HsSinReproducir;	
	private Estado estado;
	
	protected Popularidad() {
		this.reproducciones=0;
		this.likes=0;
		this.dislikes=0;
		this.estado=Estado.NORMAL;
	}	

	public Icono getPopularidad() {
		if (Normal.getState(this.likes, this.dislikes, this.reproducciones, this.estado, this.HsSinReproducir)==true) {
			this.estado=Estado.NORMAL;
			return MUSICAL_NOTE; 	
		}
		if (Auge.getState(this.likes, this.dislikes, this.reproducciones, this.estado, this.HsSinReproducir)==true) {
			this.estado=Estado.AUGE;
			return ROCKET;		
		}
		if (Tendencia.getState(this.likes, this.dislikes, this.reproducciones, this.estado, this.HsSinReproducir)==true) {
			this.estado=Estado.TENDENCIA;
			return FIRE;
		}
		return null;			
	}	

}
