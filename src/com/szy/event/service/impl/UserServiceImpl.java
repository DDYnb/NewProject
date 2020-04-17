package com.szy.event.service.impl;

import com.szy.event.dao.impl.UserDaoImpl;
import com.szy.event.entity.User;
import com.szy.event.service.UserService;

public class UserServiceImpl implements UserService {

	private static UserDaoImpl userDao = new UserDaoImpl();
	
	//�û���¼
	@Override
	public User login(String userName, String userPassWord) {
		//���ó־ò�����ݿ��ȡ����
		User user = userDao.login(userName, userPassWord);
		//�ǿգ�����user����
		if(user != null) {
			return user;
		}
		//���򣬷���null
		return null;
	}

	//�û�ע��
	@Override
	public boolean register(String userName, String UserPassWord) {

		//��Dao�����Ƿ�ע��ɹ��Ĳ���ֵ
		boolean flag = userDao.resigter(userName, UserPassWord);
		
		if (flag) {
			return true;
		}
		
		return false;
	}

}
