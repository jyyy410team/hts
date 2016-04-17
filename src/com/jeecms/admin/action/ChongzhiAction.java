package com.jeecms.admin.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.http.impl.cookie.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeecms.admin.domain.BankInfo;
import com.jeecms.admin.service.ChongzhiService;
import com.jeecms.caiwu.domain.CaiWu;
import com.jeecms.login.service.LoginService;
import com.jeecms.reg.domain.AdminUser;
import com.jeecms.reg.domain.User;
import com.jeecms.until.CookiesUtils;

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
	@RequestMapping(value = "/saveChongZhi")
	public String saveChongZhi(AdminUser adminUser,HttpServletRequest request,
			HttpServletResponse response, Model model,@RequestParam(value = "money") int money) {
		AdminUser adminUserTemp=(AdminUser) chongzhiService.queryBeanBySth(AdminUser.class, " and AdminUser='"+adminUser.getAdminUser()+"'");
		if (adminUserTemp!=null) {
			CaiWu caiWu = new CaiWu();
			caiWu.setID(2);
			caiWu.setFlag(1);
			caiWu.setOperator(CookiesUtils.getCookieValueByName(request, "AdminUser"));
			caiWu.setLeixing("账号充值");
			caiWu.setVipUser(adminUser.getAdminUser());
			caiWu.setJine(money);//验证
			//caiWu.setData(DateUtils.formatDate(new Date(),"YYYY-mm-dd HH:ii:ss"));
			
			chongzhiService.saveBean(caiWu);
			/**
			 * $yue=$rss["yue"]+$jine;
	$sqlu="update admin set yue=".$yue." where AdminUser='".$VipUser."'";
			 */
		}
		return "redirect:chongzhi.do";
		
	}

}
