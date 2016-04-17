package com.jeecms.caiwu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeecms.caiwu.service.iface.ICaiWuService;
import com.jeecms.core.CmsConstants;
import com.jeecms.core.Page;
import com.jeecms.reg.domain.User;

@Controller
@RequestMapping(value = "/")
public class CaiWuAction {
@Autowired 
ICaiWuService caiWuService;


@RequestMapping(value = "/caiwu")
public String caiwuList(HttpServletRequest request,HttpServletResponse response, Model model,Page page){
	page= caiWuService.getPageList(User.class, CmsConstants.pageSize, page.getCurrent_page(),true);
	model.addAttribute("page", page); 
	return "admin/caiwu";

}

}
