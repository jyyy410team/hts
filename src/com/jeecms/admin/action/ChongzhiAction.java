package com.jeecms.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeecms.admin.domain.BankInfo;
import com.jeecms.admin.service.ChongzhiService;
import com.jeecms.login.service.LoginService;
import com.jeecms.reg.domain.User;

@Controller
@RequestMapping(value = "/")
public class ChongzhiAction {
	
	@Autowired
	ChongzhiService chongzhiService;

	@RequestMapping(value = "/chongzhi")
	public String loginView(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Cookie[] a=request.getCookies();
		for (Cookie cookie : a) {
			if (cookie.getName().equals("AdminUser")) {
				model.addAttribute(cookie.getName(), cookie.getValue());
			}
		}
		List<BankInfo> beans = chongzhiService.getBankInfos();
		
		
		model.addAttribute("beans", beans);
		return "admin/chongzhi";// 跳到登录界面
	}

}
