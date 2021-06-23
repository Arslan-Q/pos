package com.gui;

import javax.swing.*;
import java.awt.*;

public class gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Changes from Arslan Ahsan
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//Changes from Hasssaan Nasir
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					//e.printStackTrace();

				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		/*
		public void run() {
				//Changes from Hasssaan Nasir
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		*/
	}

}
