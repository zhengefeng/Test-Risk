package com.risk.dal.credit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ProductCallDetail {
    private Integer id;

    private Integer productid;

    private Integer companyid;

    private Integer consumerid;

    private String productname;

    private BigDecimal price;

    private String returncode;

    private String returndata;

    private Short status;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getConsumerid() {
        return consumerid;
    }

    public void setConsumerid(Integer consumerid) {
        this.consumerid = consumerid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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