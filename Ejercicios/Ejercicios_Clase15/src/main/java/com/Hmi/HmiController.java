package com.Hmi;

import java.awt.EventQueue;

public class HmiController {
	
	public static void getVista() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HmiVista frame = new HmiVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
