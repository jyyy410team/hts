package com.jeecms.caiwu.service.iface;

import com.jeecms.cms.service.IBaseService;
import com.jeecms.core.Page;



public interface ICaiWuService extends IBaseService{
	
	public <T> Page getPageList(Class<T> class1, int pageSize, int pageNo,boolean isOrderBydesc,String whereStr);

	

}
