package com.jeecms.until;

import java.util.Date;

import org.apache.http.impl.cookie.DateUtils;

import com.jeecms.cms.service.IBaseService;

public class HtsUtil {
/**
 * 获取订单id  时间+随机数
 * 描述：
 * @靳阳阳
 * 2016-8-28
 */
	
	public static String getOrderId(IBaseService baseService) {
		Date sysDate=baseService.getSysDateTime();
		String orderIdStr=DateUtils.formatDate(sysDate, "yyyyMMdd")+MathUtils.getRandom(10000,99999)+"";
			return  orderIdStr;
		
	}
	
	public static String getData(IBaseService baseService) {
		return CommonDateUtil.getDateTime_Str(baseService.getSysDateTime());
	}
}
