package com.risk.integration.api;

/**
 * Created by buwei.heng on 2016/4/14.
 */
public class ApplyInfo {

    private String sorgcode;
    private String sname;
    private String scerttype;
    private String scertno;
    private String dapplydate;

    public String getIapplysum() {
        return iapplysum;
    }

    public void setIapplysum(String iapplysum) {
        this.iapplysum = iapplysum;
    }

    public String getIapplymonth() {
        return iapplymonth;
    }

    public void setIapplymonth(String iapplymonth) {
        this.iapplymonth = iapplymonth;
    }

    public String getIapplystatus() {
        return iapplystatus;
    }

    public void setIapplystatus(String iapplystatus) {
        this.iapplystatus = iapplystatus;
    }

    private String iapplysum;
    private String iapplymonth;
    private String sapplytype;
    private String iapplystatus;
    private String sapplyno;


    public String getSorgcode() {
        return sorgcode;
    }

    public void setSorgcode(String sorgcode) {
        this.sorgcode = sorgcode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScerttype() {
        return scerttype;
    }

    public void setScerttype(String scerttype) {
        this.scerttype = scerttype;
    }

    public String getScertno() {
        return scertno;
    }

    public void setScertno(String scertno) {
        this.scertno = scertno;
    }

    public String getDapplydate() {
        return dapplydate;
    }

    public void setDapplydate(String dapplydate) {
        this.dapplydate = dapplydate;
    }

    public String getSapplytype() {
        return sapplytype;
    }

    public void setSapplytype(String sapplytype) {
        this.sapplytype = sapplytype;
    }


    public String getSapplyno() {
        return sapplyno;
    }

    public void setSapplyno(String sapplyno) {
        this.sapplyno = sapplyno;
    }
}
