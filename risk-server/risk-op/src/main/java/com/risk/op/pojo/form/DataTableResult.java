package com.risk.op.pojo.form;

import java.util.ArrayList;
import java.util.List;

import com.common.utils.page.Pagination;

/**
 * @author zhuqiang
 * @version $Id: DataTableResult.java, v 0.1 2016年1月18日 下午4:48:09 zhuqiang Exp $
 */
public class DataTableResult<T> {
	// pageSize
	private int draw;
	// totalCount
	private int recordsTotal;
	// totalCount
	private int recordsFiltered;
	// dataobj
	private List<T> data = new ArrayList<T>();

	public DataTableResult() {

	}

	public DataTableResult(Pagination<?, T> page) {
		this(page.getTotalCount(), page.getDataList());
	}

	public DataTableResult(int draw, int recordsTotal, int recordsFiltered, List<T> data) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	public DataTableResult(int draw, int recordsTotal, List<T> data) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsTotal;
		this.data = data;
	}

	public DataTableResult(int recordsTotal, List<T> data) {
		super();
		this.draw = 0;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsTotal;
		this.data = data;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
