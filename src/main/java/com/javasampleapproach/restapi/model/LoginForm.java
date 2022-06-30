package com.javasampleapproach.restapi.model;

public class LoginForm {

	private String userName;
	private String password;
	private String finYear;
	private String role;
	private boolean isSuccess;

	public LoginForm() {
	}

	public LoginForm(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public LoginForm(String userName, String password, String finYear) {
		this.userName = userName;
		this.password = password;
		this.finYear = finYear;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}

	public String getFinYear() {
		return finYear;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	@Override
	public String toString() {
		return "LoginForm [userName=" + userName + ", password=" + password + ", finYear=" + finYear + "]";
	}

}
