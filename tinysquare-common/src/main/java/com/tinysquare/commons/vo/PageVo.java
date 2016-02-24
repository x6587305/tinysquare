package com.tinysquare.commons.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PageVo {

	private Integer pageNum;

	private Integer pageSize = 10;

	private Integer totalCount;

	private Integer totalPage;

	private Object result;

	public PageVo(Integer pageNum) {
		super();
		this.pageNum = pageNum;
	}

	public PageVo(Integer pageNum, Integer pageSize) {
		super();
		this.pageNum = pageNum;
		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		}
	}

	@JsonIgnore(value = true)
	public Integer getPageBegin() {
		if (this.pageNum != null && this.pageSize != null) {
			return this.pageNum == null || this.pageNum <= 1 ? 0 : ((this.pageNum - 1) * this.pageSize);
		}
		return 0;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		if (this.totalCount != null && this.pageSize != null && this.pageSize > 0) {
			this.totalPage = (int) Math.ceil(this.totalCount.doubleValue() / this.pageSize.doubleValue());
		}
		return this.totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
