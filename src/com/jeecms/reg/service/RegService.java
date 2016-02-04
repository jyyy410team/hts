package com.jeecms.reg.service;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecms.reg.dao.RegDao;
import com.jeecms.reg.domain.User;
@Service
public class RegService {
	@Autowired
	RegDao regDao;

	public int addUser(User user) {
		Date date = new Date();
		String time = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
		user.setRegtime(time);
		return regDao.addUser(user);
	}
}
