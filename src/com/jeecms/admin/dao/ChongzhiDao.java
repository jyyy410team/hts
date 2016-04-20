package com.jeecms.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jeecms.admin.domain.BankInfo;
import com.jeecms.cms.dao.BaseDao;

@Repository
public class ChongzhiDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<BankInfo> getBankInfos() {
		String sql = " from BankInfo order by ID asc";
		List<BankInfo> list = (List<BankInfo>) this.getSession()
				.createQuery(sql).list();
		System.out.println(list.size());
		return list;
	}

	public <T> void updateBean(Object object) {
        this.getHibernateTemplate().update(object);
	}
}
