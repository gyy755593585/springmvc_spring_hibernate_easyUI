package com.wuji.demo.integration.model;

import java.util.List;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
public class Pager<T> {

	private List<T> rows;

	private int pageOffset;

	private long total;

	private int pageSize;

	/**
	 * Get the value of or reference to rows.
	 *
	 * @return the rows
	 */
	public List<T> getRows() {
		return this.rows;
	}

	/**
	 * Assign the value of rows to rows.
	 *
	 * @param rows the rows to set
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	/**
	 * Get the value of or reference to pageOffset.
	 *
	 * @return the pageOffset
	 */
	public int getPageOffset() {
		return this.pageOffset;
	}

	/**
	 * Assign the value of pageOffset to pageOffset.
	 *
	 * @param pageOffset the pageOffset to set
	 */
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	/**
	 * Get the value of or reference to total.
	 *
	 * @return the total
	 */
	public long getTotal() {
		return this.total;
	}

	/**
	 * Assign the value of total to total.
	 *
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * Get the value of or reference to pageSize.
	 *
	 * @return the pageSize
	 */
	public int getPageSize() {
		return this.pageSize;
	}

	/**
	 * Assign the value of pageSize to pageSize.
	 *
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
