package com.Trabajo_Practico_Final.JFrame;


public abstract class HmiData {	
	
	private static String LBL_RESULTADO1;
	private static String LBL_RESULTADO2;

	public HmiData() {}
	
	public static String getLblResultado1() {
		return LBL_RESULTADO1;
	}
	
	public static void setLblResultado1(String res) {
		LBL_RESULTADO1 = res;
	}
	
	public static String getLblResultado2() {
		return "<html><p>"+LBL_RESULTADO2+"</p></html>";
	}
	
	public static void setLblResultado2(String res) {
		LBL_RESULTADO2 = res;
	}

}
