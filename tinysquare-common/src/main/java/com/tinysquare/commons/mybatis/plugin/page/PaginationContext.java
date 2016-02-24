package com.tinysquare.commons.mybatis.plugin.page;

public class PaginationContext {

	private static final ThreadLocal<Integer> PAGE_CONTEXT_THREAD_LOCAL = new ThreadLocal<Integer>();

	public static int getPageContext() {
		Integer totalCount = PAGE_CONTEXT_THREAD_LOCAL.get();
		if (totalCount == null) {
			totalCount = new Integer(0);
			PAGE_CONTEXT_THREAD_LOCAL.set(totalCount);
		}
		return totalCount.intValue();
	}

	public static void removeContext() {
		PAGE_CONTEXT_THREAD_LOCAL.remove();
	}

	public static void setContext(Integer count) {
		if (count == null) {
			count = 0;
		}
		PAGE_CONTEXT_THREAD_LOCAL.set(count);
	}
}
