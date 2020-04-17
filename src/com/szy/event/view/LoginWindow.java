package com.szy.event.view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.szy.event.controller.AdminController;
import com.szy.event.controller.UserController;
import com.szy.event.entity.*;

public class LoginWindow {

	private JFrame loginWindow;
	private JTextField field;
	private JPasswordField pwdField;
	static UserController userController = new UserController();
	static AdminController adminController = new AdminController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.loginWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginWindow = new JFrame();
		loginWindow.setResizable(false);
		loginWindow.getContentPane().setBackground(Color.WHITE);
		loginWindow.setTitle("\u767B\u5F55");
		loginWindow.setBounds(100, 100, 576, 416);
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.getContentPane().setLayout(null);
		loginWindow.setLocationRelativeTo(null);
		
		JLabel loginTitle = new JLabel("LPL\u8D5B\u4E8B\u7BA1\u7406\u7CFB\u7EDF");
		loginTitle.setVerticalAlignment(SwingConstants.TOP);
		loginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		loginTitle.setFont(new Font("宋体", Font.PLAIN, 25));
		loginTitle.setBounds(178, 0, 189, 31);
		loginWindow.getContentPane().add(loginTitle);
		
		JLabel nameLabel = new JLabel("  \u7528\u6237\u540D\uFF1A");
		nameLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		nameLabel.setBounds(82, 101, 107, 40);
		loginWindow.getContentPane().add(nameLabel);
		
		JLabel pwdLabel = new JLabel("  \u5BC6  \u7801\uFF1A");
		pwdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		pwdLabel.setBounds(82, 160, 107, 40);
		loginWindow.getContentPane().add(pwdLabel);
		
		field = new JTextField();
		field.setFont(new Font("宋体", Font.PLAIN, 20));
		field.setBounds(203, 108, 233, 30);
		loginWindow.getContentPane().add(field);
		field.setColumns(10);
		
		pwdField = new JPasswordField();
		pwdField.setFont(new Font("宋体", Font.PLAIN, 20));
		pwdField.setBounds(203, 167, 233, 30);
		loginWindow.getContentPane().add(pwdField);
		
		JButton register = new JButton("\u6CE8\u518C");
		register.setBackground(Color.WHITE);
		register.setFont(new Font("宋体", Font.PLAIN, 19));
		register.setBounds(267, 302, 100, 40);
		loginWindow.getContentPane().add(register);
		register.addActionListener(new ActionListener() {
			//点击注册按钮，进入注册界面
			@Override
			public void actionPerformed(ActionEvent e) {
				new ResigterWindow();
				loginWindow.dispose();
			}
		});
		
		JButton login = new JButton("\u767B\u5F55");
		login.setBackground(Color.WHITE);
		login.setFont(new Font("宋体", Font.PLAIN, 19));
		login.setBounds(267, 235, 100, 40);
		loginWindow.getContentPane().add(login);

		JComboBox typeSelect = new JComboBox();
		typeSelect.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9\u7528\u6237\u7C7B\u578B", "\u7528  \u6237", "\u7BA1\u7406\u5458"}));
		typeSelect.setFont(new Font("宋体", Font.PLAIN, 19));
		typeSelect.setBounds(82, 240, 158, 31);
		loginWindow.getContentPane().add(typeSelect);
		typeSelect.addItemListener(new ItemListener() {
			//添加监听器
			@Override
			public void itemStateChanged(ItemEvent e) {
				//处理选中的
				if (e.getStateChange()==ItemEvent.SELECTED){
					if (typeSelect.getSelectedIndex() == 1) {
						login.addActionListener(new ActionListener() {
							//用户登录
							@Override
							public void actionPerformed(ActionEvent e) {
								//获取用户名和密码
								String userName = field.getText();
								String userPassWord = new String(pwdField.getPassword());
								User user = new User(userName, userPassWord);
								User result = userController.login(user);
								if (result != null) {
//									System.out.println("yes");
									new UserMainWindow();
									loginWindow.dispose();
								}else {
									//重新登录
									JOptionPane.showMessageDialog(loginWindow, "用户名或密码错误", "提示", JOptionPane.INFORMATION_MESSAGE);
									new LoginWindow();
									loginWindow.dispose();
								}
							}
						});
					}
					if (typeSelect.getSelectedIndex() == 2) {
						login.addActionListener(new ActionListener() {
							//管理员登录
							@Override
							public void actionPerformed(ActionEvent e) {
								String adminName = field.getText();
								String adminPassWord = new String(pwdField.getPassword());
								Admin admin = new Admin(adminName, adminPassWord);
								Admin result = adminController.login(admin);
								if (result != null) {
//									System.out.println("yes1");
									new AdminMainWindow();
									loginWindow.dispose();
								}else {
									//重新登录
									JOptionPane.showMessageDialog(loginWindow, "用户名或密码错误", "提示", JOptionPane.INFORMATION_MESSAGE);
									new LoginWindow();
									loginWindow.dispose();
								}
							}
						});
					}
				}
				
			}
		});
		
		JLabel tipLabel = new JLabel("\u65B0\u7528\u6237\u8BF7\u70B9\u51FB->");
		tipLabel.setFont(new Font("SimSun", Font.PLAIN, 15));
		tipLabel.setBounds(141, 315, 112, 18);
		loginWindow.getContentPane().add(tipLabel);
		loginWindow.setVisible(true);
	}
}
