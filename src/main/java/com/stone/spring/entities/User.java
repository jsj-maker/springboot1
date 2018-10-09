package com.stone.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "R_STONE_USER")
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getUserId() {
		return userId;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	@Column(name = "userpwd")
	public String getUserpwd() {
		return userpwd;
	}

}
