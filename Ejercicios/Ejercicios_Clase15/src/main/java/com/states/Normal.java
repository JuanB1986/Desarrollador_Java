package com.states;

public class Normal {

	private Normal() {}
	
	public static boolean getState(int likes, int dislikes, int reproducciones, Estado estado, int HsSinReproducir) {
		if (reproducciones<=1000 || dislikes>=5000 || HsSinReproducir>=24) {
			return true;
		}	

		return false;
	}	
}