package com.Trabajo_Practico_Final.models;

import java.util.List;

public class ReglasPuntaje {
	
	private final static int puntosAciertos = 1;
	private final static int puntosAciertosRondas = 3;
	
	private ReglasPuntaje() {}
	
	//Puntaje por aciertos de partidos comunes
	public  static int puntosPorAcierto() {
		return puntosAciertos;
	}
	
	//Puntaje por acertar rondas completas
	public static int puntosAciertosPorRondas(List<Pronostico> listaPronosticos, String persona) {
		int rondasAcertadas=0;
		int cuentaRondas=0;
		int cantAciertosRonda=0;
		int ronda=0;
		
		for (Pronostico pron : listaPronosticos) {
			
			if (ronda != Integer.parseInt(pron.getRonda().getRonda().strip() )){
				ronda = Integer.parseInt(pron.getRonda().getRonda().strip());
				if ((cuentaRondas == cantAciertosRonda) && cuentaRondas>0 ) {
					rondasAcertadas++;
				}
			}
			
			if (pron.getPersona().equals(persona)==true) {
				cuentaRondas++;
				if (pron.getPuntaje()>0) {
					++cantAciertosRonda;
				}				
			}
		}		
		return puntosAciertosRondas*rondasAcertadas;
	}
	
	
		
}
