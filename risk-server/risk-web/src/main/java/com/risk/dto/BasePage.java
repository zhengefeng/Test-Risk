package com.risk.dto;

/**
 * Created by Administrator on 2016/8/26.
 */
public class BasePage {

    private Integer startPage;

    private Integer pageSize;

    public Integer getStartIndex(){
        return (startPage-1) * pageSize;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
