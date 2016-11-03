package com.jeecms.cms.service;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.impl.cookie.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jeecms.caiwu.domain.Webinfo;
import com.jeecms.cms.dao.BaseDao;
import com.jeecms.core.Page;
import com.jeecms.until.CommonDateUtil;
import com.jeecms.until.HttpUtils;
import com.jeecms.until.MathUtils;
@Service
public class BaseServiceImpl implements IBaseService{
	@Autowired
	BaseDao baseDao;
	public <T> List<T> getList(Class<T> class1) {
		List<T> list=baseDao.getList(class1);
		return list;
		
	}
	public <T> Page getPageList(Class<T> class1,int pageSize,int pageNo,boolean isOrderByDesc,String whereStr) {
		if (isOrderByDesc) {
			Page page= baseDao.getPageList( class1,pageSize,pageNo, isOrderByDesc,whereStr);
			return page;
		}
		Page page= baseDao.getPageList( class1,pageSize,pageNo, false,whereStr);
		return page;
		
	}
	public <T> Object getBeanById(Class<T> class1,int id) {
		Object object = baseDao.getBeanById(class1, id);
		return object;
	}
	public <T> void delete(Class<T> t, String id) {
	
		 baseDao.delete(t, id);
		
	}
	public <T> Object queryBeanBySth(Class<T> class1, String whereSth) {
		// TODO Auto-generated method stub
		return baseDao.queryBeanBySth(class1, whereSth);
	}
	public void saveBean(Object object) {
		// TODO Auto-generated method stub
		baseDao.saveBean(object);
	}
	
	
	public <T> void updateBean(Object object) {
		baseDao.updateBean(object);
		
		// TODO Auto-generated method stub
		
	}
	public Date getSysDateTime() {
		// TODO Auto-generated method stub
		return baseDao.getSysDateTime();
	}
	public String getOrderId() {
		Date sysDate=getSysDateTime();
		String orderIdStr=DateUtils.formatDate(sysDate, "yyyyMMdd")+MathUtils.getRandom(10000,99999)+"";
			return  orderIdStr;
	}
	public String getData() {
		return CommonDateUtil.getDateTime_Str(getSysDateTime());
		
	}
	
	public Map<String, Object> getCityWeather(String cityName) {
		String str="";
		Map<String, Object> responSt=new HashMap<String, Object>();
		try {
		String url ="http://api.map.baidu.com/telematics/v3/weather?location=+"+URLEncoder.encode(cityName, "utf-8")+"&output=json&ak=MCIB4KEMkUG6KT3dvAUvOlGS";
			str=HttpUtils.get(url);
			JSONObject jsonObject=JSONObject.fromObject(str);
			JSONArray results=(JSONArray) jsonObject.get("results");
			JSONObject result0 =(JSONObject) results.get(0);
			JSONArray weather_data =(JSONArray) result0.get("weather_data");
			JSONObject today =(JSONObject) weather_data.get(0);
			String todayweather=(String) today.get("weather");
			String todaytemperature=(String) today.get("temperature");
			int atemp =todaytemperature.indexOf("℃");
			todaytemperature=todaytemperature.substring(0, atemp);
			responSt.put("weather", todayweather);
			responSt.put("temperature", todaytemperature);
			jsonObject=JSONObject.fromObject(responSt);
			str=jsonObject.toString();
			
		} catch (Exception e) {
			e.getMessage();
		}
		if (str==null) {
			str="";
		}
		return responSt;
	}
	public void initData(Model model) {
			List<Webinfo> webinfos = baseDao.getList(Webinfo.class);
				model.addAttribute("web", webinfos.get(0));
			}
		

	

}
