package com.jeecms.until;

import java.util.Date;

import org.apache.http.impl.cookie.DateUtils;


/**
 * 自己的日期工具类
 * 描述：
 * @靳阳阳
 * @2016-8-27
 */
public class CommonDateUtil {
	/**
	 * 获取时间戳
	 * 描述：
	 * @靳阳阳
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTime_Str(Date in_date) {
		return DateUtils.formatDate(in_date, "yyyy-MM-dd HH:mm:ss");
		
	}
	
	/**
	 * 获取时间戳
	 * 描述：
	 * @靳阳阳
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static String getDate_Str(Date in_date) {
		return DateUtils.formatDate(in_date, "yyyy-MM-dd");
		
		
	}

	
}
