package com.risk.integration.api;

/**
 * Created by li on 2015/12/1.
 */
public class QueryRecord {
    private String org;
    private String reason;
    private String datetime;

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
