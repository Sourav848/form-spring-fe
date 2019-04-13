package com.form.spring.interceptor;

import com.form.spring.model.User;

public class SessionWrapper {


	private User user;
	
	private String userToken;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	
	

	
}



