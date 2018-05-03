package com.login;

public class LoginDao implements LoginService{
	public LoginDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}
}
