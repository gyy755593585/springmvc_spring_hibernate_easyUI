package com.wuji.demo.integration.model;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
public class SystemContext {
	// ------- Constants (static final) ----------------------------------------

	// ------- Static Variables (static) ---------------------------------------
	private static ThreadLocal<Integer> pageOffset = new ThreadLocal<>();

	private static ThreadLocal<Integer> pageSize = new ThreadLocal<>();
	// ------- Instance Variables (private) ------------------------------------

	/**
	 * Get the value of or reference to pageOffset.
	 *
	 * @return the pageOffset
	 */
	public static int getPageOffset() {
		return pageOffset.get();
	}

	/**
	 * Assign the value of pageOffset to pageOffset.
	 *
	 * @param pageOffset the pageOffset to set
	 */
	public static void setPageOffset(int _pageOffset) {
		pageOffset.set(_pageOffset);
	}

	public static void removePageOffset() {
		pageOffset.remove();
	}

	/**
	 * Get the value of or reference to pageSize.
	 *
	 * @return the pageSize
	 */
	public static int getPageSize() {
		return pageSize.get();
	}

	/**
	 * Assign the value of pageSize to pageSize.
	 *
	 * @param pageSize the pageSize to set
	 */
	public static void setPageSize(int _pageSize) {
		pageSize.set(_pageSize);
	}

	public static void removPageSize() {
		pageSize.remove();
	}

	// ------- Constructors ----------------------------------------------------

	// ------- Instance Methods (public) ---------------------------------------

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
