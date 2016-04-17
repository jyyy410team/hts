package com.jeecms.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecms.cms.dao.BaseDao;
import com.jeecms.core.Page;
@Service
public class BaseServiceImpl implements IBaseService{
	@Autowired
	BaseDao baseDao;
	public <T> List<T> getList(Class<T> class1) {
		List<T> list=baseDao.getList(class1);
		return list;
		
	}
	public <T> Page getPageList(Class<T> class1,int pageSize,int pageNo,boolean istrue) {
		if (istrue) {
			Page page= baseDao.getPageList( class1,pageSize,pageNo, " order by id desc ");
			return page;
		}
		Page page= baseDao.getPageList( class1,pageSize,pageNo, "");
		return page;
		
	}
	public <T> Object getBeanById(Class<T> class1,int id) {
		Object object = baseDao.getBeanById(class1, id);
		return object;
	}
	public <T> void delete(Class<T> t, String id) {
	
		 baseDao.delete(t, id);
		
	}

	

}
