package com.Trabajo_Practico_Final.models;

import lombok.Data;

public @Data class Pronostico {
	
	
	private Ronda ronda;
	private String persona;
	private String resultado;
	
	
	public Pronostico(Ronda ronda, String persona, String resultado) {
		this.setPersona(persona);
		this.setRonda(ronda);
		this.setResultado(resultado);
	}
	
	
	public int getPuntaje() {
		
		if ( (this.ronda.getPartido().getGolesEquipo1() > this.ronda.getPartido().getGolesEquipo2()) && this.resultado.equals("Gana1"))
		{
			return 1;
		}
		
		if ( (this.ronda.getPartido().getGolesEquipo1() < this.ronda.getPartido().getGolesEquipo2()) && this.resultado.equals("Gana2"))
		{
			return 1;
		}
		
		if ( (this.ronda.getPartido().getGolesEquipo1() == this.ronda.getPartido().getGolesEquipo2()) && this.resultado.equals("Empate"))
		{
			return 1;
		}
		return 0;
	}
	
	
	
}
