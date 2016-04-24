package com.jeecms.cms.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jeecms.core.Page;
@Repository
public class BaseDao extends HibernateDaoSupport {
	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {

		super.setSessionFactory(sessionFactory);
	}
	
	public String hql="";
	
	/**
	 * 分页查询公用方法
	 * @param class1 类.class
	 * @param pageSize  每页大小
	 * @param pageNumber  当前页码
	 * 排序方式
	 * @param whereStr  查询条件
	 * @return
	 */
	@SuppressWarnings("unchecked")

	public  <T> Page getPageList(Class<T> class1,int pageSize,int pageNo,boolean isOrderByDesc,String whereStr) {
		String orderbySth="";
		if (isOrderByDesc) {
			orderbySth=" order by ID desc";
		}
		if (StringUtils.isNotBlank(whereStr)) {
			whereStr=" and "+whereStr;
		}
		List<T>  list=this.getHibernateTemplate().find("from "+class1.getName()+" where 1=1  "+whereStr+orderbySth);
		List<T>  list2= this.getSession().createQuery("from "+class1.getName()+" where 1=1  "+whereStr+orderbySth).setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
		Page page = new Page();
		page.setCurrent_page(pageNo);
		page.setList(list2);
		page.setTotal_count(list.size());
		page.setLast_page(list.size()%pageSize+1);
		page.setCurrent_page(pageNo);
		page.setPage_size(pageSize);
		int maxPageNum = (int) (page.getTotal_count() % pageSize == 0 ? page.getTotal_count() / pageSize: (page.getTotal_count() / pageSize + 1));// 总页数要判断
	    page.setTotal_page(maxPageNum);
		return page;
		
	}
	
	/**
	 * 
	 * @param class1
	 * @param id
	 * @return
	 */
	public <T> Object getBeanById(Class<T> class1,int id) {
		Object bean = this.getSession().get(class1, id);
		return bean;
		
	}
	
	public <T> Object queryBeanBySth(Class<T> class1,String whereSth) {
		hql=" from "+class1.getName()+" where 1=1 "+whereSth;
		Object bean =  getSession().createQuery(" from com.jeecms.reg.domain.AdminUser where 1=1  and adminUser='admin'").uniqueResult();
		return bean;
	}
	
	public <T> List<T> getList(Class<T> class1) {
		List<T> list=this.getHibernateTemplate().loadAll(class1);
		return list;
		
	}
	
	public <T> void delete(Class<T> t, String id) {
		this.getHibernateTemplate().delete(this.getSession().get(t, Integer.parseInt(id)));
		
	}
	
	public   void saveBean(Object object) {
		this.getHibernateTemplate().save(object);
		
	}
	
	public <T> void updateBean(Object object) {
        this.getHibernateTemplate().update(object);
	}
	
}
