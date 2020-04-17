package com.szy.event.service;

import com.szy.event.entity.Admin;

public interface AdminService {
	
	Admin login(String adminName, String adminPassword);
	
	boolean register(String adminName, String adminPassWord);

}
