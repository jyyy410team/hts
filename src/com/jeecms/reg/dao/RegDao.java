package com.jeecms.reg.dao;

import org.springframework.stereotype.Repository;

import com.jeecms.cms.dao.BaseDao;
import com.jeecms.reg.domain.User;

@Repository
public class RegDao extends BaseDao {
	public int addUser(User user) {
		this.getSession().save(user);
		
		return 1;
	}
}
