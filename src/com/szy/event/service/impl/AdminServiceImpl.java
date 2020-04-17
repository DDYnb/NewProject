package com.szy.event.service.impl;

import com.szy.event.dao.impl.AdminDaoImpl;
import com.szy.event.entity.Admin;
import com.szy.event.service.AdminService;

public class AdminServiceImpl implements AdminService{

	private static AdminDaoImpl adminDao = new AdminDaoImpl();
	
	@Override
	public Admin login(String adminName, String adminPassWord) {

		//���ó־ò�����ݿ��ȡ����
		Admin admin = adminDao.login(adminName, adminPassWord);
		//�ǿգ�����user����
		if(admin != null) {
			return admin;
		}
		//���򣬷���null
		return null;
	}

	@Override
	public boolean register(String adminName, String adminPassWord) {

		//��Dao�����Ƿ�ע��ɹ��Ĳ���ֵ
		boolean flag = adminDao.resigter(adminName, adminPassWord);
				
		if (flag) {
			return true;
		}
		
		return false;
	}

}
