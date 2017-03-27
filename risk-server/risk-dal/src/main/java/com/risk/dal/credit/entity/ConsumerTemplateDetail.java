package com.risk.dal.credit.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

public class ConsumerTemplateDetail {
    private Integer id;

    private String consumername;

    private Integer consumerid;

    private Integer companyid;

    private Integer templateid;

    private String params;

    private String orderid;

    private String personname;

    private String cardid;

    private String returndata;

    private BigDecimal totalprice;

    @JSONField(format = "yyyy-MM-dd")
    private Date createtime;

    @JSONField(format = "yyyy-MM-dd")
    private Date updatetime;

    public String getConsumername() {
        return consumername;
    }

    public void setConsumername(String consumername) {
        this.consumername = consumername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConsumerid() {
        return consumerid;
    }

    public void setConsumerid(Integer consumerid) {
        this.consumerid = consumerid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Integer templateid) {
        this.templateid = templateid;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname == null ? null : personname.trim();
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    public String getReturndata() {
        return returndata;
    }

    public void setReturndata(String returndata) {
        this.returndata = returndata == null ? null : returndata.trim();
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}