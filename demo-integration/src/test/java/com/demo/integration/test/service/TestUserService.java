/**
 * WUJI CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: WUJI
 *
 * Copyright © 2017 WUJI Corporation. All rights reserved.
 */
package com.demo.integration.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuji.demo.integration.model.Pager;
import com.wuji.demo.integration.model.SystemContext;
import com.wuji.demo.integration.model.User;
import com.wuji.demo.integration.service.UserService;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/applicationContext-*.xml")
public class TestUserService {

	@Resource(name = "userService")
	private UserService userService;

	@Test
	public void testAddUser() {
		User user = new User();
		for (int i = 0; i < 20; i++) {
			user.setUsername("admin" + i);
			user.setPassword("test");
			this.userService.add(user);
		}
	}

	@Test
	public void testListUser() {
		List<User> users = this.userService.listAll();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void testFindUser() {
		SystemContext.setPageOffset(20);
		SystemContext.setPageSize(10);
		Pager pager = this.userService.find();
		List<User> users = pager.getRows();
		for (User user : users) {
			System.out.println(user);
		}
	}
}
