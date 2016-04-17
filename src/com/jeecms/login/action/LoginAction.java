package com.jeecms.login.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeecms.core.CmsConstants;
import com.jeecms.core.Page;
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
		
		if (cookies!=null) {
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
	/*	Cookie cookie1 = new Cookie("AdminUser", VipUser);
		response.addCookie(cookie1);*/
		return "index";// 跳到原来登录界面
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
		
		
		//需要写的代码
		String VipUser=userVo.getUserName();
		String VipPass=userVo.getPassWord();
		
		int fg=-1;
		String ip="";
		String date="";
		
		User user =loginService.getUserByUserNameAndPass(VipUser, VipPass);
		if (user!=null) {//没有用户，说明用户名密码错误，返回到首页登录页面index,重新登录
			
			date=user.getData();
			
			Cookie cookie1= new Cookie("ckey", "yes");
			Cookie cookie2= new Cookie("AdminUser", VipUser);
			Cookie cookie3= new Cookie("fg", user.getFlag()+"");
			Cookie cookie4= new Cookie("ips", user.getIp());
			Cookie cookie5= new Cookie("dt", user.getData());
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			response.addCookie(cookie4);
			response.addCookie(cookie5);
			
             if (user.getFlag()==2) {//加盟合作用户
            	return "user/indexs";//用户登录成功
			}else {
				return "user/index";//核心代理，企业用户
			}
		}else {
			AdminUser adminUser =loginService.getAdminUserByUserNameAndPass(VipUser, VipPass);
			
			if (adminUser!=null) {
				date=adminUser.getData();
				
				Cookie cookie1= new Cookie("ckey", "yes");
				Cookie cookie2= new Cookie("AdminUser", VipUser);
				Cookie cookie3= new Cookie("fg", adminUser.getFlag()+"");
				Cookie cookie4= new Cookie("ips", adminUser.getIp());
				Cookie cookie5= new Cookie("dt", adminUser.getData());
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				response.addCookie(cookie3);
				response.addCookie(cookie4);
				response.addCookie(cookie5);
				return "admin/index";//登录成功
			}else {
				adminUser =loginService.findAdminUsers();
				if (adminUser!=null) {
					model.addAttribute("msg", "用户名密码错误!");//用户名密码错误
					return "admin/indexs";
				}else {
					if (true) {
						date=adminUser.getData();
						Cookie cookie1= new Cookie("ckey", "yes");
						Cookie cookie2= new Cookie("AdminUser", VipUser);
						Cookie cookie3= new Cookie("fg", adminUser.getFlag()+"");
						Cookie cookie4= new Cookie("ips", adminUser.getIp());
						Cookie cookie5= new Cookie("dt", adminUser.getData());
						response.addCookie(cookie1);
						response.addCookie(cookie2);
						response.addCookie(cookie3);
						response.addCookie(cookie4);
						response.addCookie(cookie5);
						return "admin/indexs";//登录成功
					} else {
						model.addAttribute("msg", "用户名密码错误!");//用户名密码错误
						return "admin/indexs";
					}
				}
			}
		}
		
		
		

		//return "main";//返回内容页面，进入系统
	}

	public void addCookies(HttpServletResponse response) {
		
	}
	
	@RequestMapping(value = "/baiduMap")
	public String login2(HttpServletRequest request,HttpServletResponse response, Model model){
				return "test/baiduMap";
		
	}
	
	
	/**
	 * 查询所有普通用户信息 order by ID desc
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/viplist")
	public String viplistView(HttpServletRequest request,HttpServletResponse response, Model model,@RequestParam(defaultValue="1",required=false)int current_page,String[] deleteIds){
		Page page= loginService.getPageList(User.class, CmsConstants.pageSize, current_page," order by id desc");
		page.setAction("viplist.do");
		page.setCurrent_page(current_page);
		model.addAttribute("page", page); 
		return "admin/vipList";
		
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model  是后台传递数据，到前台用的
	 * @param id  会员id,点击的时候，带着这个会员的唯一标识id，去打开对应的会员详细信息页面
	 * @return
	 */
	//对应跳转标签的目的地址 <a href="vipinfo.do?id=${bean.ID}" class="tablelink">会员信息</a>  点击，跳转到这个方法，这个方法执行完，跳转到详情页面
	@RequestMapping(value = "/vipinfo")
	public String vipinfoView(HttpServletRequest request,HttpServletResponse response, Model model,@RequestParam(required=false)int id){
		User userBean = (User) loginService.getBeanById(User.class, 1);
		model.addAttribute("bean", userBean);
		return "admin/vipinfo";//跳转到admin文件夹下面，vipinfo.html页面
		
	}
	@RequestMapping(value = "/vipinfo/delete")
	public String delete(HttpServletRequest request,HttpServletResponse response, Model model,String[] deleteIds) {
		System.out.println("1");
		for (String id : deleteIds) {
			loginService.delete(User.class, id);
		}
		
		return "redirect:../viplist.do";
		
	}
}
