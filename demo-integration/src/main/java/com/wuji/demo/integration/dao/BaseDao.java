package com.wuji.demo.integration.dao;

import java.util.List;

import com.wuji.demo.integration.model.Pager;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
public interface BaseDao<T> {

	public void add(T t);

	public void update(T t);

	public void delete(long id);

	public T load(long id);

	public List<T> list(String hql, Object[] args);

	public List<T> list(String hql);

	public List<T> list(String hql, Object object);

	public Pager find(String hql, Object[] args);

	public Pager find(String hql, Object arg);

	public Pager find(String hql);
}
