package com.rainbowpro.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class InternalFrameTest extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalFrameTest frame = new InternalFrameTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InternalFrameTest() {
		setFrameIcon(new ImageIcon(InternalFrameTest.class.getResource("/images/rainbow_24px_1139532_easyicon.net.png")));
		setIconifiable(true);
		setClosable(true);
		setBackground(Color.WHITE);
		setTitle("\u5173\u4E8ERainbow");
		setBounds(100, 100, 952, 458);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(InternalFrameTest.class.getResource("/images/Rainbow.jpg")));
		getContentPane().add(label, BorderLayout.CENTER);

	}
}
