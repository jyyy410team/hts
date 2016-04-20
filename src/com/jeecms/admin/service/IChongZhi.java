package com.jeecms.admin.service;

import java.util.List;

import com.jeecms.admin.domain.BankInfo;
import com.jeecms.cms.service.IBaseService;

public interface IChongZhi extends IBaseService{

	public <T>  void updateBean(Object object);

	List<BankInfo> getBankInfos();

}
