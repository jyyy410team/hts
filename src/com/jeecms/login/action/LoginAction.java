package com.jeecms.login.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jeecms.cms.domain.SessionUser;
import com.jeecms.core.CmsConstants;
import com.jeecms.core.Page;
import com.jeecms.login.service.LoginService;
import com.jeecms.login.vo.LoginUserVo;
import com.jeecms.reg.domain.AdminUser;
import com.jeecms.reg.domain.User;
import com.jeecms.until.CookiesUtils;
import com.jeecms.until.Md5Util;
/**
 * 
 * 描述： 世界上，最可怕的事情就是人老的太快，老去的时候，没有为梦想奋斗过，没有实现愿望，人就死去了。
 * @靳阳阳
 * @2016-8-27
 */
@SessionAttributes("sessionUser")  
@Controller
@RequestMapping(value = "/")
public class LoginAction {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/index")
	public String loginView(HttpServletRequest request,HttpServletResponse response, Model model,SessionUser sessionUser) {
		//
		
		//数据库用户用户,是否存在的标志
		Integer ufalg = -1;// index分两部分，显示首页index的登录界面部分，还是欢迎界面部分  //数据库用户用户区是否存在的标志

		String vipUserName = "";
		String adminUserName = "";
		String  username="";
		String userpath = "";
		int fg = -1;
		String jiaose = "";
		vipUserName=sessionUser.getVipUser();
		adminUserName=sessionUser.getAdminUser();
		fg=sessionUser.getFg();
		

		if (StringUtils.isNotBlank(vipUserName)) {
			User vipUser = loginService.getUserByName(vipUserName);
			if (vipUser != null) {
				userpath = "user/index";//???返回登录界面使用
				username=vipUserName;
				ufalg=1;//数据库用户用户区是否存在的标志
				vipUser.setHeadpic(vipUser.getHeadpic().substring(vipUser.getHeadpic().indexOf("/")));
				model.addAttribute("user", vipUser);//yue ip data 用user.yue取

				if (fg!=-1) {//角色区分标志
					switch (fg) {
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
		} else if (StringUtils.isNotBlank(adminUserName)) {
			AdminUser adminUser = loginService.getAdminUserByName(adminUserName);
			if (adminUser != null) {
				userpath = "admin/index.do";//????
				adminUser.setHeadpic(adminUser.getHeadpic().substring(adminUser.getHeadpic().indexOf("/")));
				model.addAttribute("user", adminUser);
				username=adminUserName;
				ufalg=1;
				if (fg!=-1) {
					switch (fg) {
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
		model.addAttribute("userpath", userpath);
		model.addAttribute("ufalg",ufalg);
		model.addAttribute("VipUser",vipUserName);
		model.addAttribute("AdminUser",adminUserName);
		model.addAttribute("fg", fg);
		model.addAttribute("username", username);
		model.addAttribute("jiaose", jiaose);
		loginService.initData(model);//inc是随机数   include ("include/config.php");  web.data 是网站信息
		return "index";// 跳到原来登录界面
	}

	@RequestMapping(value = "admin/top")
	public String topView(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "admin/top";// 跳到登录界面
	}

	@RequestMapping(value = "admin/left")
	public String leftView(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "admin/left";// 跳到登录界面
	}

	@RequestMapping(value = "admin/main")//???干嘛用的
	public String indexView(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "admin/main";// 跳到登录界面
	}

	@RequestMapping(value = "admin/footer")
	public String footView(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		return "admin/footer";// 跳到登录界面
	}

	@RequestMapping(value = "/loginOut")
	public String loginOut(HttpServletRequest request,HttpServletResponse response, ModelMap model,HttpSession session,SessionUser sessionUser) {
			sessionUser=new SessionUser();
			model.addAttribute("sessionUser", sessionUser);
		return "index";// 跳到登录界面
	}

	/**
	 * 点击登录的方法
	 * @param request
	 * @param response
	 * @param model
	 * @param userVo
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, LoginUserVo userParam,SessionUser sessionUser) {
		String code = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

		if (userParam.getYzm().equalsIgnoreCase(code)) {//??暂时不要
			model.addAttribute("msg", "验证码错误!");
			return "index";
		}  
		
		
		//需要写的代码
		String VipUser=userParam.getUserName();
		String VipPass=Md5Util.GetMD5Code(userParam.getPassWord());
		
		int fg=-1;
		String ip="";
		String date="";
		
		User user =loginService.getUserByUserNameAndPass(VipUser, VipPass);
		if (user!=null) {//没有用户，说明用户名密码错误，返回到首页登录页面index,重新登录
			
			
			sessionUser.setCkey("yes");
			sessionUser.setAdminUser(VipUser);
			sessionUser.setFg(user.getFlag());
			sessionUser.setIps(user.getIp());
			sessionUser.setDt(user.getData());
			model.addAttribute("sessionUser", sessionUser);
			
             if (user.getFlag()==2) {//加盟合作用户
            	return "user/indexs";//用户登录成功
			}else {
				return "user/index";//核心代理，企业用户
			}
		}else {
			AdminUser adminUser =loginService.getAdminUserByUserNameAndPass(VipUser, VipPass);
			
			if (adminUser!=null) {
				date=adminUser.getData();
				sessionUser.setCkey("yes");
				sessionUser.setAdminUser(VipUser);
				sessionUser.setFg(adminUser.getFlag());
				sessionUser.setIps(adminUser.getIp());
				sessionUser.setDt(adminUser.getData());
				model.addAttribute("sessionUser", sessionUser);
				return "admin/index";//登录成功
			}else {
				adminUser =loginService.findAdminUsers();
				if (adminUser!=null) {
					model.addAttribute("msg", "用户名密码错误!");//用户名密码错误
					return "index";
				}else {
					String xPassWord=Md5Util.GetMD5Code(Md5Util.GetMD5Code(userParam.getPassWord()));
					if ("admin123".equals(userParam.getUserName())&&"0192023a7bbd73250516f069df18b500".equals(xPassWord)) {
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
						return "admin/indexs";//管理员登录成功
					} else {
						model.addAttribute("msg", "用户名密码错误!");//用户名密码错误
						return "index";
					}
				}
			}
		}
		
		
		

		//return "main";//返回内容页面，进入系统
	}

	
	
	@RequestMapping(value = "/baiduMap")
	public String baiduMap(HttpServletRequest request,HttpServletResponse response, Model model){
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
		Page page= loginService.getPageList(User.class, CmsConstants.pageSize, current_page,true,"");
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
	
	@RequestMapping(value = "/admin/index")
	public String adminPage(HttpServletRequest request,HttpServletResponse response, Model model) {
		
		
		return "admin/index";
		
	}
}
