package com.risk.integration.api;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by li on 2015/11/9.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpecRrade {
    private String org;
    private String name;
    private String certtype;
    private String certno;
    private String account;
    private String tradetype;
    private String tradedate;
    private String tradeamt;
    private String details;
    private String phone;
    private String address;

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCerttype() {
        return certtype;
    }

    public void setCerttype(String certtype) {
        this.certtype = certtype;
    }

    public String getCertno() {
        return certno;
    }

    public void setCertno(String certno) {
        this.certno = certno;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTradetype() {
        return tradetype;
    }

    public void setTradetype(String tradetype) {
        this.tradetype = tradetype;
    }

    public String getTradedate() {
        return tradedate;
    }

    public void setTradedate(String tradedate) {
        this.tradedate = tradedate;
    }

    public String getTradeamt() {
        return tradeamt;
    }

    public void setTradeamt(String tradeamt) {
        this.tradeamt = tradeamt;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return new StringBuilder("name:").append(name).append(",certno:").append(certno).append(",account:").append(account).toString();
    }
}
