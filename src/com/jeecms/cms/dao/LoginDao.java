package com.jeecms.cms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jeecms.cms.domain.CmsRole;

@Repository
public class LoginDao extends BaseDao {

	public String getStr() {

		List rolesobject2 = this.getSession()
				.createSQLQuery("select * from jc_role where 1=1 ").list();
		Object[] object = (Object[]) rolesobject2.get(0);
		for (Object object2 : object) {
			System.out.print(object2 + "  ");

		}

		return rolesobject2.size() + "";
	}

	public void addBean(CmsRole cmsRole) {
		cmsRole.setIssupper(2);

		this.getHibernateTemplate().save(cmsRole);
		List rolelist = this.getHibernateTemplate().find(" from CmsRole ");

		List<CmsRole> cmsRoles = this.getHibernateTemplate().find(
				" from CmsRole ");
		System.out.println(cmsRoles.size());

	}

	public Pager getCmsRoles(int pageSize, int pageNum) {

		Pager pager = new Pager();
		Session session = this.getSession();
		Query q = session.createQuery("select count(g) from CmsRole g");
		long total = (Long) q.uniqueResult();
		int maxPageNum = (int) (total % pageSize == 0 ? total / pageSize
				: (total / pageSize + 1));// 总页数要判断
		pager.setTotal(total);
		pager.setPageNum(pageNum);
		pager.setPageSize(pageSize);
		pager.setMaxPageNum(maxPageNum);// 总共多少页
		pager.setRows(session.createQuery("from CmsRole")
				.setFirstResult((pageNum - 1) * pageSize)
				.setMaxResults(pageSize).list());
		return pager;
	}

	public void test() {
		Session session = this.getSession();
		session.createCriteria(CmsRole.class).add(Restrictions.gt("", "a"))
				.list();
	}
//
}
