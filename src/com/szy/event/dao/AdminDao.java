package com.szy.event.dao;

import com.szy.event.entity.Admin;

public interface AdminDao {

	//����Ա��¼
	Admin login(String name, String Password);
	
	//����Աע��
	boolean resigter(String name, String passWord);
	
}
