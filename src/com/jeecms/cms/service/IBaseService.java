package com.jeecms.cms.service;

import java.util.List;

import com.jeecms.core.Page;

public interface IBaseService {
	public <T> List<T> getList(Class<T> class1);

	public <T> Page getPageList(Class<T> class1, int pageSize, int pageNo,boolean isOrderBydesc,String whereStr);

	public <T> Object getBeanById(Class<T> class1, int id);
	
	public <T> void delete(Class<T> t,String id);
	
	public <T> Object queryBeanBySth(Class<T> class1,String whereSth);
	
	public void saveBean(Object object);
}
