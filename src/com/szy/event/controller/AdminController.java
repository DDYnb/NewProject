package com.szy.event.controller;

import com.szy.event.entity.Admin;
import com.szy.event.service.impl.AdminServiceImpl;

public class AdminController {

	private static AdminServiceImpl adminService = new AdminServiceImpl();
	
	//管理员登录
	public Admin login(Admin admin) {
		//从前端获取登录用户信息
		String adminName = admin.getAdminName();
		String adminPassWord = admin.getAdminPassWord();
		//调用服务层方法
		Admin result = adminService.login(adminName, adminPassWord);
		//返回数据到前端
		return result;
	}
	
	//管理员注册
	public boolean register(String name, String passWord) {
		//返回是否注册成功
		return adminService.register(name, passWord);
		
	} 

	
}
