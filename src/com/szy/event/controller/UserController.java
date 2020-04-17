package com.szy.event.controller;

import com.szy.event.entity.User;
import com.szy.event.service.impl.UserServiceImpl;

public class UserController {
	
	private static UserServiceImpl userService = new UserServiceImpl();

	//�û���¼
	public User login(User user) {
		//��ǰ�˻�ȡ��¼�û���Ϣ
		String userName = user.getUserName();
		String userPassWord = user.getUserPassWord();
		//���÷���㷽��
		User result = userService.login(userName, userPassWord);
		//�������ݵ�ǰ��
		return result;
		
	}
	
	//�û�ע��
	public boolean register(String name, String passWord) {
		//�����Ƿ�ע��ɹ�
		return userService.register(name, passWord);
		
	} 

}
