package com.jeecms.login.vo;
/**
 * 
* @Title: User.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author : jinyangyang
* @date :2016-2-3 下午5:01:31 
* @version V1.0
 */
public class LoginUserVo {
	private String userName;
	private String displayName;
	private String passWord;
	private String yzm;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getYzm() {
		return yzm;
	}

	public void setYzm(String yzm) {
		this.yzm = yzm;
	}

}
