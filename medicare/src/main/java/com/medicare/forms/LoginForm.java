package com.medicare.forms;

public class LoginForm {

	private String username;
	private String password;
	private String formAct;
    private Boolean loginSuccessfull;
	public Boolean getLoginSuccessfull() {
		return loginSuccessfull;
	}
	public void setLoginSuccessfull(Boolean loginSuccessfull) {
		this.loginSuccessfull = loginSuccessfull;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFormAct() {
		return formAct;
	}
	public void setFormAct(String formAct) {
		this.formAct = formAct;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
