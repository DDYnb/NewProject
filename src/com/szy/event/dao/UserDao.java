package com.szy.event.dao;
/*
 * 用户的Dao层接口
 */

import com.szy.event.entity.User;

public interface UserDao {

	//用户登录
	User login(String name, String passWord);
	//用户注册
	boolean resigter(String name, String passWord);
	
}
