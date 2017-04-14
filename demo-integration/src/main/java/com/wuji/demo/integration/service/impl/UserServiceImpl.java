/**
 * WUJI CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: WUJI
 *
 * Copyright © 2017 WUJI Corporation. All rights reserved.
 */
package com.wuji.demo.integration.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuji.demo.integration.dao.UserDao;
import com.wuji.demo.integration.model.Pager;
import com.wuji.demo.integration.model.User;
import com.wuji.demo.integration.service.UserService;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name = "userDao")
	private UserDao userDao;

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void add(User user) {
		this.userDao.add(user);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void delete(long id) {
		this.userDao.delete(id);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void update(User user) {
		this.userDao.update(user);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public User load(long id) {
		return this.userDao.load(id);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public List<User> listAll() {
		return this.userDao.list("from User");
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public Pager<User> find() {
		return this.userDao.find("from User");
	}

}
