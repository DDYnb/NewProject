package com.szy.event.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class AdminMainWindow {

	private JFrame adminMainWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainWindow window = new AdminMainWindow();
					window.adminMainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminMainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		adminMainWindow = new JFrame();
		adminMainWindow.setTitle("\u4E3B\u9875");
		adminMainWindow.setBounds(100, 100, 691, 513);
		adminMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminMainWindow.getContentPane().setLayout(null);
		adminMainWindow.setLocationRelativeTo(null);
		adminMainWindow.setVisible(true);

	}

}
