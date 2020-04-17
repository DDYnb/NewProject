package com.szy.event.service.impl;

import com.szy.event.dao.impl.UserDaoImpl;
import com.szy.event.entity.User;
import com.szy.event.service.UserService;

public class UserServiceImpl implements UserService {

	private static UserDaoImpl userDao = new UserDaoImpl();
	
	//用户登录
	@Override
	public User login(String userName, String userPassWord) {
		//调用持久层从数据库获取数据
		User user = userDao.login(userName, userPassWord);
		//非空，返回user对象
		if(user != null) {
			return user;
		}
		//否则，返回null
		return null;
	}

	//用户注册
	@Override
	public boolean register(String userName, String UserPassWord) {

		//从Dao层获得是否注册成功的布尔值
		boolean flag = userDao.resigter(userName, UserPassWord);
		
		if (flag) {
			return true;
		}
		
		return false;
	}

}
