/**
 * WUJI CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: WUJI
 *
 * Copyright © 2017 WUJI Corporation. All rights reserved.
 */
package com.wuji.demo.integration.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wuji.demo.integration.model.SystemContext;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
public class SystemContextInterceptor implements HandlerInterceptor {

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		int page = 1;
		int rows = 10;
		try {
			rows = Integer.parseInt(request.getParameter("rows"));
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			page = 1;
			rows = 10;
		}
		int pageOffset = (page - 1) * rows;
		SystemContext.setPageOffset(pageOffset);
		SystemContext.setPageSize(rows);
		System.out.println(SystemContext.getPageOffset());
		return true;
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		SystemContext.removePageOffset();
		SystemContext.removPageSize();
	}

}
