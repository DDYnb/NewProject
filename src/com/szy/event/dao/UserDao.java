package com.szy.event.dao;
/*
 * �û���Dao��ӿ�
 */

import com.szy.event.entity.User;

public interface UserDao {

	//�û���¼
	User login(String name, String passWord);
	//�û�ע��
	boolean resigter(String name, String passWord);
	
}
