package com.jeecms.cms.action.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author jinyy
 * @date 2015-11-13
 * 
 */
public class JsonUtil {
	/**
	 * 
	 * @author jinyy
	 * @param obj
	 * @param isArray  是否是数组
	 * @return
	 */
	public static String pareseObject(Object obj, boolean isArray) {

		if (obj != null) {
			if (isArray && !(obj instanceof Collection)) {
				List<Object> list = new ArrayList<Object>();
				list.add(obj);
				return JSON.toJSONString(list);
			} else if (!isArray && (obj instanceof Collection)) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("list", obj);
				return JSON.toJSONString(map);
			} else {
				return JSON.toJSONString(obj);
			}

		} else {
			if (isArray) {
				return "[]";
			} else {
				return "{}";
			}
		}

	}

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", 1);
		map.put("2", 2);

		List<Object> list = new ArrayList<Object>();
		List<Object> list2 = new ArrayList<Object>();
		list2.add(3);
		list2.add(4);
		list.add(list2);
		list.add(new Date());
		System.out.println(pareseObject(map, false));

	}
}
