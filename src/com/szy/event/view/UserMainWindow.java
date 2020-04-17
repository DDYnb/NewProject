package com.szy.event.view;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import com.szy.event.util.DrawTable;
import java.awt.Font;
import javax.swing.ListSelectionModel;

public class UserMainWindow {

	private JFrame userMainWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainWindow window = new UserMainWindow();
					window.userMainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserMainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		userMainWindow = new JFrame();
		userMainWindow.setResizable(false);
		userMainWindow.setTitle("\u4E3B\u9875");
		userMainWindow.getContentPane().setBackground(new Color(240, 240, 240));
		userMainWindow.getContentPane().setLayout(null);
		userMainWindow.setBounds(100, 100, 926, 621);
		userMainWindow.setLocationRelativeTo(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 916, 580);
		userMainWindow.getContentPane().add(tabbedPane);
		
		JPanel raceHall = new JPanel();
		tabbedPane.addTab("\u8D5B\u4E8B\u5927\u5385", null, raceHall, null);
		tabbedPane.setEnabledAt(0, true);
		raceHall.setLayout(null);
		
		//加入Jtable组件
		DrawTable table = new DrawTable();
		String[] columnNames = {"ID", "主场", "客场", "时间", "价格"};
		JTable raceTable = new JTable(table.drowRaceTable(), columnNames);
		raceTable.setRowSelectionAllowed(false);
		raceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		raceTable.setFont(new Font("SimSun", Font.PLAIN, 15));
		
		
		JScrollPane scrollPane = new JScrollPane(raceTable);
		scrollPane.setBounds(14, 13, 700, 511);
		raceHall.add(scrollPane);
		
		JPanel userOrders = new JPanel();
		tabbedPane.addTab("\u6211\u7684\u8BA2\u5355", null, userOrders, null);
		userOrders.setLayout(null);
		tabbedPane.setEnabledAt(1, true);
		
		userMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userMainWindow.setVisible(true);
	}
}
