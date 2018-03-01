package com.zendaimoney.laocaibao.model;

/**
 * 保存个人登录信息
 * 
 * @author 00225075
 * 
 */
public class UserLogin {
	// 后台返回的登录信息
	private UserLoginInfoItem uInfoItem;
	// 登录密码
	private String password;

	public UserLoginInfoItem getuInfoItem() {
		return uInfoItem;
	}

	public void setuInfoItem(UserLoginInfoItem uInfoItem) {
		this.uInfoItem = uInfoItem;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
