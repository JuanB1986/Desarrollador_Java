package com.Trabajo_Practico_Final.models;

import lombok.Data;

public @Data class Partido {

	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;

	public Partido(Equipo equipo1, int goles1, int goles2, Equipo equipo2) {
		this.setEquipo1(equipo1);
		this.setGolesEquipo1(goles1);
		this.setEquipo2(equipo2);
		this.setGolesEquipo2(goles2);
	}
	
	
}
