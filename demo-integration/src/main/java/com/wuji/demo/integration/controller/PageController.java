/**
 * WUJI CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: WUJI
 *
 * Copyright © 2017 WUJI Corporation. All rights reserved.
 */
package com.wuji.demo.integration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@Controller
public class PageController {

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}

}
