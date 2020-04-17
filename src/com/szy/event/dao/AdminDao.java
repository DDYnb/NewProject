package com.szy.event.dao;

import com.szy.event.entity.Admin;

public interface AdminDao {

	//管理员登录
	Admin login(String name, String Password);
	
	//管理员注册
	boolean resigter(String name, String passWord);
	
}
