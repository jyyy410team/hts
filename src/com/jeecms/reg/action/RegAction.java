package com.jeecms.reg.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeecms.reg.domain.User;
import com.jeecms.reg.service.RegService;

/**
 * 
 * @Title: RegAction.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author : JinYangY
 * @date :2016-2-4 上午11:35:39
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/")
public class RegAction {

	@Autowired
	RegService regService;

	@RequestMapping(value = "reg")
	public String regView() {

		return "reg";
	}

	@RequestMapping(value = "reg2")
	public String reg(User user, @RequestParam(required = false) String code,
			@RequestParam(required = false) String pass2,
			HttpServletRequest request, ModelMap model) {
		try {
			 regService.addUser(user);
			model.addAttribute("msg", "恭喜您，注册成功！");
		} catch (Exception e) {
			model.addAttribute("msg", "注册失败");
			e.printStackTrace();

		}

		return "reg";
	}
}
