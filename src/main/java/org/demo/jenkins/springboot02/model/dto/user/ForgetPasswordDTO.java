package org.demo.jenkins.springboot02.model.dto.user;


/**
 * 忘记密码
 * @author izhem
 *
 */
public class ForgetPasswordDTO {
	
	/** 账号/邮箱/手机号*/
    private String username;
	
    /** 手机号码*/
    private String telephone;
	
	/** 手机验证码*/
    private String smscode;
	
	/** 密码*/
    private String password;
	
	/** 密码校验*/
    private String rePassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSmscode() {
		return smscode;
	}

	public void setSmscode(String smscode) {
		this.smscode = smscode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
}
