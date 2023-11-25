package com.models;

import java.nio.charset.Charset;

public class Icono {
	
	private byte[] icono;
	
	public Icono (byte[] icono) {
		this.icono=icono;
	}
	
	public String decode() {		
		return new String(this.icono, Charset.forName("utf-8"));
	}


}
