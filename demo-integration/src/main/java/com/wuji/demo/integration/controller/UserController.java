/**
 * WUJI CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: WUJI
 *
 * Copyright © 2017 WUJI Corporation. All rights reserved.
 */
package com.wuji.demo.integration.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuji.demo.integration.model.Pager;
import com.wuji.demo.integration.model.User;
import com.wuji.demo.integration.service.UserService;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@RequestMapping("/user")
@Controller
public class UserController {

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping("/list")
	@ResponseBody
	public Pager<User> userList() {
		return this.userService.find();
	}
}
