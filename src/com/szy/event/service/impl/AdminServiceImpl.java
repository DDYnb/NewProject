package com.szy.event.service.impl;

import com.szy.event.dao.impl.AdminDaoImpl;
import com.szy.event.entity.Admin;
import com.szy.event.service.AdminService;

public class AdminServiceImpl implements AdminService{

	private static AdminDaoImpl adminDao = new AdminDaoImpl();
	
	@Override
	public Admin login(String adminName, String adminPassWord) {

		//调用持久层从数据库获取数据
		Admin admin = adminDao.login(adminName, adminPassWord);
		//非空，返回user对象
		if(admin != null) {
			return admin;
		}
		//否则，返回null
		return null;
	}

	@Override
	public boolean register(String adminName, String adminPassWord) {

		//从Dao层获得是否注册成功的布尔值
		boolean flag = adminDao.resigter(adminName, adminPassWord);
				
		if (flag) {
			return true;
		}
		
		return false;
	}

}
