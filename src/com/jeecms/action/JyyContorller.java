package com.jeecms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeecms.cms.service.LoginService;

@Controller
@RequestMapping(value = "/")
public class JyyContorller {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login")
	public String toLogin(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String code = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY); 
		System.out.println(code+"++++++++++++++++");
		
		/*model.addAttribute("title", loginService.getStr());  */
		model.addAttribute("content", " Hello world ， test my first spring mvc ! ");
		
		return "login";//跳到登录界面
	}

	@RequestMapping(value = "/login2")
	public String toIndex(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,String username, String password, String yzm) {
		String code = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY); 
		System.out.println(code+"++++++++++++++++");
		model.addAttribute("title", "a");  
		model.addAttribute("content", " Hello world ， test my first spring mvc ! ");
		
		System.err.println(username+password+yzm);
		return "index";
	}
	@RequestMapping(value = "/tomain")
	
	
	public String toMain(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String code = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY); 
		System.out.println(code+"++++++++++++++++");
		model.addAttribute("title", "a");  
		model.addAttribute("content", " Hello world ， test my first spring mvc ! ");
		return "main";
		
		//
		/**
		 * 72 how late are you open? 青儿你营业到几点。
		 * 74 how long will it take me to get there
		 * 75 how much is it ?
		 * 82 i cant affort it
		 * 83 i cant beleve it
		 * 
		 */
	}
}
