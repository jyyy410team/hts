package com.jeecms.cms.domain;

public class SessionUser {

	private String ckey;
	private String VipUser;
	private int fg;
	private String ips;
	private String dt;
	private String AdminUser;

	public String getCkey() {
		return ckey;
	}

	public void setCkey(String ckey) {
		this.ckey = ckey;
	}

	public String getVipUser() {
		return VipUser;
	}

	public void setVipUser(String vipUser) {
		VipUser = vipUser;
	}

	

	public String getIps() {
		return ips;
	}

	public void setIps(String ips) {
		this.ips = ips;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getAdminUser() {
		return AdminUser;
	}

	public void setAdminUser(String adminUser) {
		AdminUser = adminUser;
	}

	public int getFg() {
		return fg;
	}

	public void setFg(int fg) {
		this.fg = fg;
	}

	

}
