/**
 * BORGWARD CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: BORGWARD
 *
 * Copyright © 2017 BORGWARD Corporation. All rights reserved.
 */
package com.wuji.demo.integration.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.wuji.demo.integration.dao.BaseDao;
import com.wuji.demo.integration.model.Pager;
import com.wuji.demo.integration.model.SystemContext;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private Class<T> clz;

	@SuppressWarnings("unchecked")
	public Class<T> getClz() {
		if (this.clz == null) {
			this.clz = (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		}
		return this.clz;
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void delete(long id) {
		this.getHibernateTemplate().delete(this.load(id));
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public T load(long id) {
		return this.getHibernateTemplate().load(this.getClz(), id);

	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public List<T> list(String hql, Object[] args) {
		return (List<T>) this.getHibernateTemplate().find(hql, args);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public List<T> list(String hql) {
		return this.list(hql, null);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public List<T> list(String hql, Object object) {
		return this.list(hql, new Object[] { object });
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public Pager<T> find(String hql, Object[] args) {
		Pager<T> pages = new Pager<T>();
		Integer pageOffset;
		Integer pageSize;

		pageOffset = SystemContext.getPageOffset();
		pageSize = SystemContext.getPageSize();

		List<T> datas = new ArrayList<>();
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);
		Query countQuery = this.getSessionFactory().getCurrentSession().createQuery(this.getCountHql(hql));
		if (args != null) {
			int index = 0;
			for (Object arg : args) {
				query.setParameter(index, arg);
				countQuery.setParameter(index, arg);
				index++;
			}
		}
		long totalRecord = (long) countQuery.uniqueResult();
		query.setFirstResult(pageOffset).setMaxResults(pageSize);
		datas = query.list();
		pages.setRows(datas);
		pages.setPageOffset(pageOffset);
		pages.setPageSize(pageSize);
		pages.setTotal(totalRecord);
		return pages;

	}

	private String getCountHql(String hql) {
		// 获取from前面的字符串
		String f = hql.substring(0, hql.indexOf("from"));
		if ("".equals(f)) {
			hql = "select count(*) " + hql;
		} else {
			hql = hql.replace(f, "select count(*) ");
		}
		return hql;
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public Pager find(String hql, Object arg) {
		return this.find(hql, new Object[] { arg });
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public Pager<T> find(String hql) {
		return this.find(hql, null);
	}

}
