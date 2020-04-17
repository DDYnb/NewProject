package com.szy.event.entity;

public class Admin {

	private Integer adminId;
	private String adminName;
	private String adminPassWord;
	
	public Admin() {
		super();
	}

	public Admin(String adminName, String adminPassWord) {
		super();
		this.adminName = adminName;
		this.adminPassWord = adminPassWord;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassWord() {
		return adminPassWord;
	}

	public void setAdminPassWord(String adminPassWord) {
		this.adminPassWord = adminPassWord;
	}
	
	

}
