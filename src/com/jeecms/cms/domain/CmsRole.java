package com.jeecms.cms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Entity
@Table(name = "jc_role")*/
public class CmsRole {
	private Integer roleid;
	private Integer siteid;
	private String rolename;
	private Integer issupper;
/*
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy=GenerationType.AUTO)*/
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/*@Column(name = "site_id")*/
	public Integer getSiteid() {
		return siteid;
	}

	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
	}
/*
	@Column(name = "role_name")*/
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;

	}

	/*@Column(name = "is_super")*/
	public Integer getIssupper() {
		return issupper;
	}

	public void setIssupper(Integer issupper) {
		this.issupper = issupper;
	}
}
