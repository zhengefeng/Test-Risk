package com.common.utils.page;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Pagination<P, T> implements Serializable {

	private static final long serialVersionUID = -7590843676422286260L;

	public Pagination() {
		super();
	}

	public Pagination(int offset, int limit, P param) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.numPerPage = limit;
		this.param = param;
	}

	public Pagination(P param, int numPerPage, int currentPage) {
		super();
		this.offset = numPerPage * (currentPage - 1);
		this.limit = numPerPage;
		this.numPerPage = numPerPage;
		this.param = param;
		this.currentPage = currentPage;
	}

	/**
	 * 分页中每页的数量
	 */
	private int numPerPage = 20;

	/**
	 * 当前是第几页
	 */
	private int currentPage = 1;

	/**
	 * 总共有多少记录
	 */
	private int totalCount;

	/**
	 * 总共有多少页
	 */
	private int totalPageCount;

	/**
	 * 当前排序的字段
	 */
	private String orderField;

	/**
	 * 当前排序字段的方向ASC/DESC
	 */
	private String orderDirection;

	private String reverse;

	private int offset;

	private int limit;

	/**
	 * 传入查询参数
	 */
	private P param;

	/**
	 * 获取返回结果
	 */
	private List<T> dataList = null;

	public int getNumPerPage() {
		if (numPerPage > 100) {
			numPerPage = 100;
		}
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageCount() {
		if (this.totalCount > 0 && this.totalPageCount == 0) {
			if (this.totalCount % this.numPerPage == 0) {
				this.totalPageCount = this.totalCount / this.numPerPage;
			} else {
				this.totalPageCount = this.totalCount / this.numPerPage + 1;
			}
		}
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public String getReverse() {
		return reverse;
	}

	public void setReverse(String reverse) {
		this.reverse = reverse;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public P getParam() {
		return param;
	}

	public void setParam(P param) {
		this.param = param;
	}

	public List<T> getDataList() {
		if (dataList == null) {
			dataList = Collections.emptyList();
		}
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		if (dataList == null) {
			dataList = Collections.emptyList();
		}
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
