package com.risk.dal.credit.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProviderInter implements Serializable{
    private static final long serialVersionUID = 9170529587633990203L;
    private Integer id;

    private Integer productid;

    private String name;

    private String providercode;

    private String intercode;

    private BigDecimal price;

    private Integer feetype;

    private Short status;

    private String description;

    private Date updatetime;

    private Date createtime;

    public ProviderInter() {
    }

    public ProviderInter(Integer id, Integer productid, String intercode, BigDecimal price, String providercode, Integer feetype, String description) {
        this.id = id;
        this.productid = productid;
        this.intercode = intercode;
        this.price = price;
        this.providercode = providercode;
        this.feetype = feetype;
        this.description = description;
    }

    public ProviderInter(Integer id, Integer productid, String intercode) {
        this.id = id;
        this.productid = productid;
        this.intercode = intercode;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProvidercode() {
        return providercode;
    }

    public void setProvidercode(String providercode) {
        this.providercode = providercode == null ? null : providercode.trim();
    }

    public String getIntercode() {
        return intercode;
    }

    public void setIntercode(String intercode) {
        this.intercode = intercode == null ? null : intercode.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getFeetype() {
        return feetype;
    }

    public void setFeetype(Integer feetype) {
        this.feetype = feetype;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}