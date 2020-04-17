package com.szy.event.controller;

import com.szy.event.entity.Admin;
import com.szy.event.service.impl.AdminServiceImpl;

public class AdminController {

	private static AdminServiceImpl adminService = new AdminServiceImpl();
	
	//����Ա��¼
	public Admin login(Admin admin) {
		//��ǰ�˻�ȡ��¼�û���Ϣ
		String adminName = admin.getAdminName();
		String adminPassWord = admin.getAdminPassWord();
		//���÷���㷽��
		Admin result = adminService.login(adminName, adminPassWord);
		//�������ݵ�ǰ��
		return result;
	}
	
	//����Աע��
	public boolean register(String name, String passWord) {
		//�����Ƿ�ע��ɹ�
		return adminService.register(name, passWord);
		
	} 

	
}
