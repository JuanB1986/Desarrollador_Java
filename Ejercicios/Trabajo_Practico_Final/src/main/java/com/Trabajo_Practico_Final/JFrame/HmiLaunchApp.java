package com.Trabajo_Practico_Final.JFrame;

import java.awt.EventQueue;

public class HmiLaunchApp {
	public static void show() {
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
