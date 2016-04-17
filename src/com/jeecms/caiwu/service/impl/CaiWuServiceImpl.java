package com.jeecms.caiwu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecms.caiwu.dao.CaiWuDao;
import com.jeecms.caiwu.service.iface.ICaiWuService;
import com.jeecms.cms.service.BaseServiceImpl;
import com.jeecms.core.Page;

@Service
public class CaiWuServiceImpl   extends BaseServiceImpl implements ICaiWuService{
	@Autowired
	CaiWuDao caiWuDao;

	public <T> Page getPageList(Class<T> class1, int pageSize, int pageNo,
			boolean isOrderBydesc, String whereStr) {
		// TODO Auto-generated method stub
		return caiWuDao.getPageList(class1, pageSize, pageNo,  isOrderBydesc, " vipUser='"+"g"+"'");
	}

	
}
