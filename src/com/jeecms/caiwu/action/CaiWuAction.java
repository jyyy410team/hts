package com.jeecms.caiwu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeecms.caiwu.domain.CaiWu;
import com.jeecms.caiwu.service.iface.ICaiWuService;
import com.jeecms.core.CmsConstants;
import com.jeecms.core.Page;
import com.jeecms.reg.domain.User;
import com.jeecms.until.CookiesUtils;
/**
 * 财务
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/")
public class CaiWuAction {
@Autowired 
ICaiWuService caiWuService;

/**
 * 财务列表
 * @param request
 * @param response
 * @param model
 * @param page
 * @return
 */
@RequestMapping(value = "/caiwu")
	public String caiwuList(HttpServletRequest request,HttpServletResponse response, Model model,Page page){
		page=caiWuService.getPageList(CaiWu.class, CmsConstants.pageSize, page.getCurrent_page(),true, " vipUser='"+CookiesUtils.getCookieValueByName(request, "AdminUser")+"'");
		model.addAttribute("page", page); 
		return "admin/caiwu";
	}


@RequestMapping(value = "/caiwu/delete")
public String delete(HttpServletRequest request,HttpServletResponse response, Model model,String[] deleteIds) {
	for (String id : deleteIds) {
		caiWuService.delete(CaiWu.class, id);
	}
	
	return "redirect:../caiwu.do";
	
}

}
