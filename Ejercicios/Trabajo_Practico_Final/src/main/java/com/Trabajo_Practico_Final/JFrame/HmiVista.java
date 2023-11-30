package com.Trabajo_Practico_Final.JFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import java.awt.Font;

public class HmiVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public HmiVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel LBL_IMAGEN = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, LBL_IMAGEN, 170, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, LBL_IMAGEN, 215, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, LBL_IMAGEN, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, LBL_IMAGEN, 5, SpringLayout.WEST, contentPane);
		LBL_IMAGEN.setIcon(new ImageIcon("./Imagenes/qatar.jpg"));
		contentPane.add(LBL_IMAGEN);
		
		JLabel lblNewLabel = new JLabel("Resultados:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, LBL_IMAGEN);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 15, SpringLayout.EAST, LBL_IMAGEN);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -46, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JLabel LBL_RESULTADOS1 = new JLabel("New label");
		sl_contentPane.putConstraint(SpringLayout.WEST, LBL_RESULTADOS1, 16, SpringLayout.EAST, LBL_IMAGEN);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, LBL_RESULTADOS1, -72, SpringLayout.SOUTH, LBL_IMAGEN);
		sl_contentPane.putConstraint(SpringLayout.NORTH, LBL_RESULTADOS1, 37, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, LBL_RESULTADOS1, -37, SpringLayout.EAST, contentPane);
		//LBL_RESULTADOS1.setBackground(Color.gray);
		//LBL_RESULTADOS1.setOpaque(true);
		LBL_RESULTADOS1.setText(HmiData.getLblResultado2());
		contentPane.add(LBL_RESULTADOS1);
	}
}
