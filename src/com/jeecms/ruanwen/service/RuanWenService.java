package com.jeecms.ruanwen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecms.cms.service.BaseServiceImpl;
import com.jeecms.ruanwen.dao.RuanWenDao;
import com.jeecms.ruanwen.service.Inter.IRuanWenService;
@Service
public class RuanWenService extends BaseServiceImpl implements IRuanWenService{

	
	@Autowired
	RuanWenDao ruanWenDao;

}
