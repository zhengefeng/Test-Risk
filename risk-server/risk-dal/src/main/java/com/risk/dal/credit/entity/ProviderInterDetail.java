package com.risk.dal.credit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ProviderInterDetail {
    private Integer id;

    private Integer providerinterid;

    private Integer providercode;

    private String providerintercode;

    private BigDecimal price;

    private Short status;

    private String params;

    private String returncode;

    private String returndata;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProviderinterid() {
        return providerinterid;
    }

    public void setProviderinterid(Integer providerinterid) {
        this.providerinterid = providerinterid;
    }

    public Integer getProvidercode() {
        return providercode;
    }

    public void setProvidercode(Integer providercode) {
        this.providercode = providercode;
    }

    public String getProviderintercode() {
        return providerintercode;
    }

    public void setProviderintercode(String providerintercode) {
        this.providerintercode = providerintercode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getReturncode() {
        return returncode;
    }

    public void setReturncode(String returncode) {
        this.returncode = returncode == null ? null : returncode.trim();
    }

    public String getReturndata() {
        return returndata;
    }

    public void setReturndata(String returndata) {
        this.returndata = returndata == null ? null : returndata.trim();
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