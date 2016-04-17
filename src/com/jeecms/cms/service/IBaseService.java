package com.jeecms.cms.service;

import java.util.List;

import com.jeecms.core.Page;

public interface IBaseService {
	public <T> List<T> getList(Class<T> class1);

	public <T> Page getPageList(Class<T> class1, int pageSize, int pageNo,boolean isOrderBydesc);

	public <T> Object getBeanById(Class<T> class1, int id);
	
	public <T> void delete(Class<T> t,String id);
}
