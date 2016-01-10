package com.jeecms.cms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecms.cms.dao.Pager;
import com.jeecms.cms.domain.CmsRole;
import com.jeecms.cms.service.LoginService;

@Controller
@RequestMapping(value = "/student")
public class StudentAction {

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/addStudent")
	public String addStudent() {
		System.out.println("adf");
		return "student/addStudent";

	}

	@RequestMapping(value = "/add")
	@ResponseBody
	public String add(Model model, @RequestParam(value = "name") String name,
			@RequestParam(value = "pass") String pass) {

		String size = loginService.getStr();
		model.addAttribute("size", size);
		CmsRole cmsRole = new CmsRole();
		cmsRole.setRolename(name);
		cmsRole.setSiteid(1);
		loginService.add(cmsRole);

		System.out.println("添加成功");

		String str =

		"{\"statusCode\":\"200\", \"message\":\"ok!\","
				+ "\"navTabId\":\"ProductList\",\"rel\":\"\",\"callbackType\":\"closeCurrent\",\"forwardUrl\":\"\"}";

		return str;
	}

	@RequestMapping(value = "/list")
	public String studentList(
			Model model,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(value = "numPerPage", required = false, defaultValue = "20") Integer numPerPage) {
		Pager page = loginService.getCmsRoles(numPerPage, pageNum);

		System.out.println(pageNum + numPerPage);
		model.addAttribute("page", page);
		return "student/studentList";
	}

	@ModelAttribute
	public void init() {
		System.out.println("bbbbbbbbb");// s
	}
}
