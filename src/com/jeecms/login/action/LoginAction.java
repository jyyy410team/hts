package com.jeecms.login.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeecms.login.service.LoginService;
import com.jeecms.login.vo.LoginUserVo;
import com.jeecms.reg.domain.AdminUser;
import com.jeecms.reg.domain.User;

@Controller
@RequestMapping(value = "/")
public class LoginAction {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/index")
	public String loginView(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		//

		int ufalg = -1;// index分两部分，显示首页index的登录界面部分，还是欢迎界面部分

		Cookie[] cookies = request.getCookies();
		String VipUser = "";
		String AdminUser = "";
		String userpath = "";
		String fg = "";
		String jiaose = "";
		String ip = "";
		String data = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("VipUser")) {
				VipUser = cookie.getValue();
				model.addAttribute(cookie.getName(), cookie.getValue());
			}

			if (cookie.getName().equals("AdminUser")) {
				AdminUser = cookie.getValue();
				model.addAttribute(cookie.getName(), cookie.getValue());
			}

			if (cookie.getName().equals("fg")) {
				fg = cookie.getValue();
				model.addAttribute(cookie.getName(), cookie.getValue());
			}

		}

		if (StringUtils.isNotBlank(VipUser)) {
			User sqlUser = loginService.getUserByName(VipUser);
			if (sqlUser != null) {
				userpath = "user/login";
				ip = request.getRemoteAddr();
				model.addAttribute("ip", ip);

				data = sqlUser.getData();
				model.addAttribute("data", data);

				if (StringUtils.isNotBlank(fg)) {
					switch (Integer.parseInt(fg)) {
					case 1:
						jiaose = "核心代理";
						break;
					case 2:
						jiaose = "合作加盟供应商";
						break;
					case 3:
						jiaose = "企业用户";
						break;

					}
				}
			}
		} else if (StringUtils.isNotBlank(AdminUser)) {
			AdminUser sqlUser2 = loginService.getAdminUserByName(AdminUser);
			if (sqlUser2 != null) {
				userpath = "admin/login";
				ip = request.getRemoteAddr();
				model.addAttribute("ip", ip);
				
				data = sqlUser2.getData();
				model.addAttribute("data", data);

				if (StringUtils.isNotBlank(fg)) {
					switch (Integer.parseInt(fg)) {
					case 1:
						jiaose = "站长";
						break;
					case 2:
						jiaose = "副站长";
						break;
					case 3:
						jiaose = "检查员";
						break;

					}
				}
			}
		} else {
			ufalg = 0;
		}

		
		model.addAttribute("ufalg", ufalg);
		Cookie cookie1 = new Cookie("AdminUser", VipUser);
		response.addCookie(cookie1);
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

	/**
	 * 登录方法
	 * @param request
	 * @param response
	 * @param model
	 * @param userVo
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, LoginUserVo userVo) {
		String code = (String) request.getSession().getAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

		if (userVo.getYzm().equalsIgnoreCase(code)) {
			model.addAttribute("msg", "验证码错误!");
			return "index";
		} else {
			
		}

		return "main";
	}

	/*
	 * @RequestMapping(value = "/error") public String error(HttpServletRequest
	 * request, HttpServletResponse response, ModelMap model) { request.get
	 * return "error";// 跳到登录界面 }
	 */

}
