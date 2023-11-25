package com.states;

public class Tendencia {

	private Tendencia() {}
	
	public static boolean getState(int likes, int dislikes, int reproducciones, Estado estado, int HsSinReproducir) {
		if (likes>20000 && reproducciones > 50000 && dislikes < 5000) {
			return true;
		}
		return false;
	}	
}