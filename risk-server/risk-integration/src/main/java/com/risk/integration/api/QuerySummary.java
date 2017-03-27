package com.risk.integration.api;

/**
 * Created by li on 2015/11/9.
 */
public class QuerySummary {
    private Integer orgCount = 0;
    private Integer queryCount = 0;
    private Integer orgCountM3 = 0;
    private Integer queryCountM3 = 0;
    private Integer orgCountM6 = 0;
    private Integer queryCountM6 = 0;
    private QueryRecord[] details;

    public Integer getOrgCount() {
        return orgCount;
    }

    public void setOrgCount(Integer orgCount) {
        this.orgCount = orgCount;
    }

    public Integer getQueryCount() {
        return queryCount;
    }

    public void setQueryCount(Integer queryCount) {
        this.queryCount = queryCount;
    }

    public Integer getOrgCountM3() {
        return orgCountM3;
    }

    public void setOrgCountM3(Integer orgCountM3) {
        this.orgCountM3 = orgCountM3;
    }

    public Integer getQueryCountM3() {
        return queryCountM3;
    }

    public void setQueryCountM3(Integer queryCountM3) {
        this.queryCountM3 = queryCountM3;
    }

    public Integer getOrgCountM6() {
        return orgCountM6;
    }

    public void setOrgCountM6(Integer orgCountM6) {
        this.orgCountM6 = orgCountM6;
    }

    public Integer getQueryCountM6() {
        return queryCountM6;
    }

    public void setQueryCountM6(Integer queryCountM6) {
        this.queryCountM6 = queryCountM6;
    }

    public QueryRecord[] getDetails() {
        return details;
    }

    public void setDetails(QueryRecord[] details) {
        this.details = details;
    }
}
