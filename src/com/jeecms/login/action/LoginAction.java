package com.jeecms.login.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeecms.login.service.LoginService;
import com.jeecms.login.vo.LoginUserVo;

@Controller
@RequestMapping(value = "/")
public class LoginAction {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/index")
	public String loginView(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "index";// 跳到登录界面
	}

	@RequestMapping(value = "/top")
	public String topView(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "top";// 跳到登录界面
	}

	@RequestMapping(value = "/left")
	public String leftView(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "left";// 跳到登录界面
	}

	@RequestMapping(value = "/index2")
	public String indexView(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "index2";// 跳到登录界面
	}

	@RequestMapping(value = "/footer")
	public String footView(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "footer";// 跳到登录界面
	}

	@RequestMapping(value = "/loginOut")
	public String loginOut(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		return "index";// 跳到登录界面
	}

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, LoginUserVo user) {
		String code = (String) request.getSession().getAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

		if (user.getYzm().equalsIgnoreCase(code)) {
			model.addAttribute("msg", "验证码错误!");
		} else {
			Cookie cookie = new Cookie("AdminUser", user.getUserName());
			response.addCookie(cookie );
			return "main";
			
		}

		return "index";
	}
	
	/*@RequestMapping(value = "/error")
	public String error(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		request.get
		return "error";// 跳到登录界面
	}*/

}
