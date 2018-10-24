package com.stone.spring.entities;




public class User {
	private long userId;
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	private String username;
	private String userpwd;

}
