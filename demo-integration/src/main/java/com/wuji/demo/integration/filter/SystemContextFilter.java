/**
 * BORGWARD CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: BORGWARD
 *
 * Copyright © 2017 BORGWARD Corporation. All rights reserved.
 */
package com.wuji.demo.integration.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.wuji.demo.integration.model.SystemContext;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
public class SystemContextFilter implements Filter {

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void destroy() {

	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		int page = 1;
		int rows = 10;
		try {
			try {
				rows = Integer.parseInt(request.getParameter("rows"));
				page = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
			}
			int pageOffset = (page - 1) * rows;
			SystemContext.setPageOffset(pageOffset);
			SystemContext.setPageSize(rows);
			System.out.println(SystemContext.getPageOffset());
			System.out.println(SystemContext.getPageSize());
			chain.doFilter(request, response);
		} finally {
			SystemContext.removePageOffset();
			SystemContext.removPageSize();
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	// ------- Constants (static final) ----------------------------------------

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	// ------- Constructors ----------------------------------------------------

	// ------- Instance Methods (public) ---------------------------------------

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
