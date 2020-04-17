package com.szy.event.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;

import com.szy.event.controller.AdminController;
import com.szy.event.controller.UserController;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ResigterWindow {

	private JFrame resigterWindow;
	private JTextField nameField;
	private JTextField pwdField;
	static UserController userController = new UserController();
	static AdminController adminController = new AdminController();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResigterWindow window = new ResigterWindow();
					window.resigterWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResigterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		resigterWindow = new JFrame();
		resigterWindow.setResizable(false);
		resigterWindow.setTitle("\u6CE8\u518C");
		resigterWindow.setBounds(100, 100, 448, 300);
		resigterWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resigterWindow.getContentPane().setLayout(null);
		resigterWindow.setLocationRelativeTo(null);
		
		JLabel resigterName = new JLabel("\u7528\u6237\u540D");
		resigterName.setFont(new Font("宋体", Font.PLAIN, 19));
		resigterName.setBounds(139, 68, 58, 18);
		resigterWindow.getContentPane().add(resigterName);
		
		JLabel resigterPwd = new JLabel("\u5BC6  \u7801");
		resigterPwd.setFont(new Font("宋体", Font.PLAIN, 19));
		resigterPwd.setBounds(139, 124, 58, 18);
		resigterWindow.getContentPane().add(resigterPwd);
		
		nameField = new JTextField();
		nameField.setFont(new Font("宋体", Font.PLAIN, 17));
		nameField.setBounds(211, 66, 86, 24);
		resigterWindow.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		pwdField = new JTextField();
		pwdField.setFont(new Font("宋体", Font.PLAIN, 17));
		pwdField.setBounds(211, 122, 86, 24);
		resigterWindow.getContentPane().add(pwdField);
		pwdField.setColumns(10);
		
		JButton resigter = new JButton("\u6CE8\u518C");
		resigter.setFont(new Font("宋体", Font.PLAIN, 20));
		resigter.setBounds(161, 200, 113, 27);
		resigterWindow.getContentPane().add(resigter);
		
		JComboBox type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9\u7528\u6237\u7C7B\u578B", "\u7528  \u6237", "\u7BA1\u7406\u5458"}));
		type.setFont(new Font("SimSun", Font.PLAIN, 15));
		type.setBounds(139, 163, 158, 24);
		type.addItemListener(new ItemListener() {
			//添加监听器
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					//只处理选中的项目
					if (type.getSelectedIndex() == 1) {
						resigter.addActionListener(new ActionListener() {
							//用户注册
							@Override
							public void actionPerformed(ActionEvent e) {
								String userName = nameField.getText();
								String userPwd = pwdField.getText();
								if(userController.register(userName, userPwd)) {
									//注册成功，弹出消息框，回到登录界面
									JOptionPane.showMessageDialog(resigterWindow, "注册成功", "提示", JOptionPane.INFORMATION_MESSAGE);
									new LoginWindow();
									resigterWindow.dispose();
								}else {
									//否则重新注册
									JOptionPane.showMessageDialog(resigterWindow, "注册失败，用户名已存在", "提示", JOptionPane.INFORMATION_MESSAGE);
									new LoginWindow();
									resigterWindow.dispose();
								}
							}
						});
					}
					if (type.getSelectedIndex() == 2) {
						resigter.addActionListener(new ActionListener() {
							//管理员注册
							@Override
							public void actionPerformed(ActionEvent e) {
								String adminName = nameField.getText();
								String adminPwd = pwdField.getText();
								if(adminController.register(adminName, adminPwd)) {
									//注册成功，弹出消息框，回到登录界面
									JOptionPane.showMessageDialog(resigterWindow, "注册成功", "提示", JOptionPane.INFORMATION_MESSAGE);
									new LoginWindow();
									resigterWindow.dispose();
								}else {
									//否则重新注册
									JOptionPane.showMessageDialog(resigterWindow, "注册失败，用户名已存在", "提示", JOptionPane.INFORMATION_MESSAGE);
									new LoginWindow();
									resigterWindow.dispose();
								}
							}
						});
					}
				}
			}
		});
		
		resigterWindow.getContentPane().add(type);
		resigterWindow.setVisible(true);
	}
}
