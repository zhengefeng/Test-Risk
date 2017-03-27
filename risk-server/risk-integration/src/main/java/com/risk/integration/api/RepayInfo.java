package com.risk.integration.api;

/**
 * Created by li on 2015/11/9.
 */
public class RepayInfo {

    private String saccount;
    private String iperiodnumber;
    private String dbillingdate;
    private String iactualpayamount;
    private String drecentpaydate;
    private String ischeduledamount;
    private String ibalance;
    private String iaccountstat;
    private String soverdue;
    private String inowoverduetimes;
    private String imaxoverduetimes;
    private String inowoverdueamount;
    private String imaxoverdueamount;

    public String getInowoverduetimes() {
        return inowoverduetimes;
    }

    public void setInowoverduetimes(String inowoverduetimes) {
        this.inowoverduetimes = inowoverduetimes;
    }

    public String getImaxoverduetimes() {
        return imaxoverduetimes;
    }

    public void setImaxoverduetimes(String imaxoverduetimes) {
        this.imaxoverduetimes = imaxoverduetimes;
    }

    public String getInowoverdueamount() {
        return inowoverdueamount;
    }

    public void setInowoverdueamount(String inowoverdueamount) {
        this.inowoverdueamount = inowoverdueamount;
    }

    public String getImaxoverdueamount() {
        return imaxoverdueamount;
    }

    public void setImaxoverdueamount(String imaxoverdueamount) {
        this.imaxoverdueamount = imaxoverdueamount;
    }

    public String getSaccount() {
        return saccount;
    }

    public void setSaccount(String saccount) {
        this.saccount = saccount;
    }

    public String getIperiodnumber() {
        return iperiodnumber;
    }

    public void setIperiodnumber(String iperiodnumber) {
        this.iperiodnumber = iperiodnumber;
    }

    public String getSoverdue() {
        return soverdue;
    }

    public void setSoverdue(String soverdue) {
        this.soverdue = soverdue;
    }

    public String getDbillingdate() {
        return dbillingdate;
    }

    public void setDbillingdate(String dbillingdate) {
        this.dbillingdate = dbillingdate;
    }

    public String getIactualpayamount() {
        return iactualpayamount;
    }

    public void setIactualpayamount(String iactualpayamount) {
        this.iactualpayamount = iactualpayamount;
    }

    public String getDrecentpaydate() {
        return drecentpaydate;
    }

    public void setDrecentpaydate(String drecentpaydate) {
        this.drecentpaydate = drecentpaydate;
    }

    public String getIscheduledamount() {
        return ischeduledamount;
    }

    public void setIscheduledamount(String ischeduledamount) {
        this.ischeduledamount = ischeduledamount;
    }

    public String getIbalance() {
        return ibalance;
    }

    public void setIbalance(String ibalance) {
        this.ibalance = ibalance;
    }

    public String getIaccountstat() {
        return iaccountstat;
    }

    public void setIaccountstat(String iaccountstat) {
        this.iaccountstat = iaccountstat;
    }
}
