package com.jeecms.caiwu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecms.caiwu.dao.CaiWuDao;
import com.jeecms.caiwu.service.iface.ICaiWuService;
import com.jeecms.caiwu.service.iface.IDaixieService;
import com.jeecms.cms.service.BaseServiceImpl;

@Service
public class CaiWuServiceImpl   extends BaseServiceImpl implements IDaixieService{
	@Autowired
	CaiWuDao caiWuDao;

	

	
}
