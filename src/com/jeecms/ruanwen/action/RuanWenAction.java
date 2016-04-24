package com.jeecms.ruanwen.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeecms.core.CmsConstants;
import com.jeecms.core.Page;
import com.jeecms.ruanwen.domain.Ruanwen_info;
import com.jeecms.ruanwen.service.Inter.IRuanWenService;

/**
 * 软文管理action
 * <p>ClassName:IDtCrVcInsurancesMgr</p>
 * <p>Title:</p>
 * <p>Description:</p>
 * <p>Copyright:Copyright (c) 2010</p>
 * <p>Company:易泓咨询管理公司</p>
 * <p>Date:2016-4-21</p>
 * <p>Modify:</p>
 * <p>Bug:</p>
 * <p>@author jin.yangyang</p>
 * <p>@version 1.0</p>	 
 *
 */
@Controller
public class RuanWenAction {
	
	@Autowired 
	IRuanWenService ruanWenService;
	@RequestMapping(value="/ruanwenList.do")
	public String ruanWenList(HttpServletRequest request,HttpServletResponse response, Model model,Page page){
		page=ruanWenService.getPageList(Ruanwen_info.class, CmsConstants.pageSize, page.getCurrent_page(),true, "");
		model.addAttribute("page", page); 
		return "admin/ruanwen";
		
	}
	
	@RequestMapping(value="/ruanwenAddView.do")
	public String ruanWenAddView() {
		return "admin/ruanwenAdd";
		
	}


}
