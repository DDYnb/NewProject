package com.szy.event.entity;

public class User {
	
	private Integer userId;
	private String userName;
	private String userPassWord;
	private Double userMoney;
	
	public String toString() {
		return userId+userName+userPassWord;
		
	}
	public User() {
		super();
	}

	public User(String userName, String userPassWord) {
		super();
		this.userName = userName;
		this.userPassWord = userPassWord;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassWord() {
		return userPassWord;
	}

	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}

	public Double getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(Double userMoney) {
		this.userMoney = userMoney;
	}

	

}
