 package com.Hmi;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;


public class HmiVista extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public HmiVista() {
		setForeground(SystemColor.inactiveCaption);
		setBackground(new Color(255, 255, 255));
		
		
		setDefaultCloseOperation(HmiVista.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 254);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(255, 255, 255));
		setContentPane(contentPane);
		
		JLabel label1 = new JLabel("");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setIcon(new ImageIcon("./Resources/youtube1.png"));
		
		JLabel lblText = new JLabel("New label");
		lblText.setForeground(Color.BLUE);
		lblText.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		lblText.setBackground(Color.GREEN);
		lblText.setText(HmiData.getText(0));
		
		JLabel lblLikes = new JLabel((String) null);
		lblLikes.setHorizontalAlignment(SwingConstants.LEFT);
		lblLikes.setForeground(new Color(0, 128, 0));
		lblLikes.setFont(new Font("Dialog", Font.BOLD, 13));
		lblLikes.setBackground(Color.WHITE);
		lblLikes.setText(HmiData.getText(1));
		
		JLabel lblDislikes = new JLabel((String) null);
		lblDislikes.setHorizontalAlignment(SwingConstants.LEFT);
		lblDislikes.setForeground(new Color(255, 0, 0));
		lblDislikes.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDislikes.setBackground(Color.WHITE);
		lblDislikes.setText(HmiData.getText(2));
		
		JLabel lblReprod = new JLabel((String) null);
		lblReprod.setHorizontalAlignment(SwingConstants.LEFT);
		lblReprod.setForeground(new Color(105, 105, 105));
		lblReprod.setFont(new Font("Dialog", Font.BOLD, 13));
		lblReprod.setBackground(Color.WHITE);
		lblReprod.setText(HmiData.getText(3));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label1, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
						.addComponent(lblText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(108)
							.addComponent(lblLikes, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDislikes, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblReprod, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblText, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblReprod, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDislikes, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLikes, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		gl_contentPane.setHonorsVisibility(false);		
		contentPane.setLayout(gl_contentPane);
		

	}
}
