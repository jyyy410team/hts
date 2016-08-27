package com.jeecms.until;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookiesUtils {
public static String getCookieValueByName(HttpServletRequest request,String cookieName) {
	String cookieName0="";
	Cookie[] cookies = request.getCookies();
	if (cookies!=null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookieName)) {
				cookieName0 = cookie.getValue();
			}
		}
	}
	
	return cookieName0;
	
}
}
