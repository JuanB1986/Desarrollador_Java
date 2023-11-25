package com.states;

public class Auge {

	private Auge() {}
	
	public static boolean getState(int likes, int dislikes, int reproducciones, Estado estado, int HsSinReproducir) {
		if (reproducciones>1000 && dislikes<20000 && likes<20000) {
			return true;
		}	

		return false;
	}
	
}
