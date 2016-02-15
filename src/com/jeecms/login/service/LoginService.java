package com.jeecms.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecms.cms.dao.LoginDao;
import com.jeecms.cms.dao.Pager;
import com.jeecms.cms.domain.CmsRole;
import com.jeecms.reg.domain.AdminUser;
import com.jeecms.reg.domain.User;

@Service
/**
 * 
 * @author Administrator
 * @date 2015-10-26
 *
 */
public class LoginService {
	@Autowired
	LoginDao loginDao;

	/**
	 * 
	 * @author jinyy
	 * @return
	 */
	public String getStr() {
		if (loginDao == null) {
			System.out.println("dao is null");
		}
		return loginDao.getStr();
	}

	public Pager getCmsRoles(int pageSize, int pageNum) {
		Pager cmsRoles = loginDao.getCmsRoles(pageSize, pageNum);
		return cmsRoles;
	}

	public void add(CmsRole cmsRole) {
		loginDao.addBean(cmsRole);
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public User getUserByName(String userName) {
		return loginDao.getUserByName(userName);		
	}

	public AdminUser getAdminUserByName(String userName) {
		// TODO Auto-generated method stub
		return loginDao.getAdminUserByName(userName);	
				}

}
