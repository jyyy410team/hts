package com.jeecms.until;

import java.util.List;

import org.springframework.ui.Model;

import com.jeecms.caiwu.domain.Webinfo;
import com.jeecms.cms.service.IBaseService;

public class ConfigPageUtil {

	public static void initData(Model model, IBaseService baseService) {
		List<Webinfo> webinfos = baseService.getList(Webinfo.class);
		if (!webinfos.isEmpty()) {
			model.addAttribute("webinfo", webinfos.get(0));
		}
	}
}
