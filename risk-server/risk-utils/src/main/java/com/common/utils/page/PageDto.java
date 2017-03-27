package com.common.utils.page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/8/26.
 */
public class PageDto<D> implements Serializable {

    private Integer totalCount;

    private Integer currentPage;

    private Integer pageSize;

    private List<D> dataList;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<D> getDataList() {
        return dataList;
    }

    public void setDataList(List<D> dataList) {
        this.dataList = dataList;
    }
}
