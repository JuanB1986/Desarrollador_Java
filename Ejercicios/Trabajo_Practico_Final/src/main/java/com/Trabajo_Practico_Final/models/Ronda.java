package com.Trabajo_Practico_Final.models;

import lombok.Data;

public  @Data class Ronda {
	
	private String ronda;
	private Partido partido;
	
	public Ronda (String ronda, Partido partido) {
		this.ronda=ronda;
		this.partido=partido;
	}	
	
	


}
