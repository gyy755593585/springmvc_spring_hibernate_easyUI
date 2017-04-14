/**
 * WUJI CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: WUJI
 *
 * Copyright © 2017 WUJI Corporation. All rights reserved.
 */
package com.wuji.demo.integration.service;

import java.util.List;

import com.wuji.demo.integration.model.Pager;
import com.wuji.demo.integration.model.User;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
public interface UserService {

	public void add(User user);

	public void delete(long id);

	public void update(User user);

	public User load(long id);

	public List<User> listAll();

	public Pager<User> find();
}
