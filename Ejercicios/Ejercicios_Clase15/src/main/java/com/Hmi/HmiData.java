package com.Hmi;

public class HmiData {
	
	private static String textValue[]=new String [5];
	
	private HmiData() {}
	
	public static void setText(String data, int index) {
		textValue[index]=data;		
	}		
	
	public static String getText(int index) {
		return textValue[index];
	}

	

}
