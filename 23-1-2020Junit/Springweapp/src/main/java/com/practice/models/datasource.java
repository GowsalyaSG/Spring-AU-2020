package com.practice.models;

public class datasource {
	private String sqlurl;
	private String username;
	private String password;

	public datasource(String sqlurl, String username, String password) {
		this.sqlurl = sqlurl;
		this.username = username;
		this.password = password;
	}

	public String getSqlurl() {
		return sqlurl;
	}

	public void setSqlurl(String sqlurl) {
		this.sqlurl = sqlurl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
