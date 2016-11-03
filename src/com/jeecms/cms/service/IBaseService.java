package com.jeecms.cms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.jeecms.core.Page;

public interface IBaseService {
	public <T> List<T> getList(Class<T> class1);

	public <T> Page getPageList(Class<T> class1, int pageSize, int pageNo,boolean isOrderBydesc,String whereStr);

	public <T> Object getBeanById(Class<T> class1, int id);
	
	public <T> void delete(Class<T> t,String id);
	
	public <T> Object queryBeanBySth(Class<T> class1,String whereSth);
	
	public void saveBean(Object object);
	
	public <T> void updateBean(Object object) ;
	
	public Date getSysDateTime();
	
	public String getOrderId();
	
	public String getData();

	public Map<String, Object> getCityWeather(String cityName);
	
	
	/**
	 * 初始化网站基本信息
	 * 描述：
	 * @靳阳阳
	 * 2016-8-27
	 * webinfo.属性
	 */
	public void initData(Model model);
}
