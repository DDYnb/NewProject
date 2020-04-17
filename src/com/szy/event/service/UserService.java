package com.szy.event.service;

import com.szy.event.entity.User;

public interface UserService {

	User login(String userName, String userPassWord);
	
	boolean register(String userName, String UserPassWord);
	
}
