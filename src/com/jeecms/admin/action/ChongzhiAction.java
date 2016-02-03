package com.jeecms.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeecms.login.service.LoginService;

@Controller
@RequestMapping(value = "/")
public class ChongzhiAction {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/chongzhi")
	public String loginView(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "admin/chongzhi";// 跳到登录界面
	}

}
