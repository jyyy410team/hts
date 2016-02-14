package com.jeecms.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecms.admin.dao.ChongzhiDao;
import com.jeecms.admin.domain.BankInfo;
@Service
public class ChongzhiService {
	@Autowired
	ChongzhiDao chongzhiDao;
	public List<BankInfo> getBankInfos() {
		return chongzhiDao.getBankInfos();
		
	}
	
}
