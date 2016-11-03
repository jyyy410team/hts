package com.jeecms.caiwu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeecms.caiwu.domain.Daixie_info;
import com.jeecms.caiwu.service.iface.IDaixieService;
import com.jeecms.core.CmsConstants;
import com.jeecms.core.Page;

/**
 * 
 * 描述：代写管理
 * @靳阳阳
 * 2016-8-16
 */
@Controller
@RequestMapping(value = "/")
public class DaixieAction {
	@Autowired
	IDaixieService daixieService;

	/**
	 * 
	 * 描述：
	 * @靳阳阳
	 * 2016-8-16
	 *
	 */
	@RequestMapping(value = "/daixieList")
	public String caiwuList(HttpServletRequest request,
			HttpServletResponse response, Model model, Page page) {
		page = daixieService.getPageList(Daixie_info.class,
				CmsConstants.pageSize, page.getCurrent_page(), true, "");
		model.addAttribute("page", page);
	
		return "admin/daixieList";
	}
	
	/**
	 * 跳转到dsinfo.html
	 * 描述：
	 * @靳阳阳
	 * 2016-8-16
	 */
	@RequestMapping(value = "/dsinfo")
	public String linkTodsinfo(HttpServletRequest request,HttpServletResponse response, Model model,Integer ID) {
		Daixie_info bean=(Daixie_info) daixieService.getBeanById(Daixie_info.class, ID);
		model.addAttribute("bean", bean);
		daixieService.initData(model);
		return "dsinfo";
	}
	
	/**
	 * 代写发布   新增
	 * 描述：
	 * @靳阳阳
	 * 2016-8-16
	 */
	@RequestMapping(value = "/daixie_add")
	public String daixieAddView() {
		return "admin/daixie_add";
		
	}

	/**
	 * 批量删除
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param deleteIds
	 * @return
	 */
	@RequestMapping(value = "/daixieList/delete")
	public String delete(HttpServletRequest request,
			HttpServletResponse response, Model model, String[] deleteIds) {
		for (String id : deleteIds) {
			daixieService.delete(Daixie_info.class, id);
		}
		return "redirect:../daixieList.do";

	}
	/**
	 * 保存代写内容
	 * 描述：
	 * @靳阳阳
	 * 2016-8-27
	@
	 */
	@RequestMapping(value = "/saveDaiXie")
	public String saveDaiXie(HttpServletRequest request,HttpServletResponse response, Model model,Daixie_info formVo,HttpSession session) {
		//??会员名称  
		formVo.setData(daixieService.getData());
		formVo.setOrder_id(daixieService.getOrderId());
		daixieService.saveBean(formVo);
		return "admin/daixie_add";
		
	}

}
