package com.szy.event.controller;

import com.szy.event.entity.User;
import com.szy.event.service.impl.UserServiceImpl;

public class UserController {
	
	private static UserServiceImpl userService = new UserServiceImpl();

	//用户登录
	public User login(User user) {
		//从前端获取登录用户信息
		String userName = user.getUserName();
		String userPassWord = user.getUserPassWord();
		//调用服务层方法
		User result = userService.login(userName, userPassWord);
		//返回数据到前端
		return result;
		
	}
	
	//用户注册
	public boolean register(String name, String passWord) {
		//返回是否注册成功
		return userService.register(name, passWord);
		
	} 

}
