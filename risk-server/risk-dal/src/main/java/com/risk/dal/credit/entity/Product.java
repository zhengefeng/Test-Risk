package com.risk.dal.credit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer id;

    private Integer providercode;

    private String name;

    private BigDecimal marketprice;

    private BigDecimal specialprice;

    private BigDecimal costprice;

    private Short status;

    private Short feetype;

    private String infotype;

    private String description;

    private String opername;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvidercode() {
        return providercode;
    }

    public void setProvidercode(Integer providercode) {
        this.providercode = providercode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(BigDecimal marketprice) {
        this.marketprice = marketprice;
    }

    public BigDecimal getSpecialprice() {
        return specialprice;
    }

    public void setSpecialprice(BigDecimal specialprice) {
        this.specialprice = specialprice;
    }

    public BigDecimal getCostprice() {
        return costprice;
    }

    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getFeetype() {
        return feetype;
    }

    public void setFeetype(Short feetype) {
        this.feetype = feetype;
    }

    public String getInfotype() {
        return infotype;
    }

    public void setInfotype(String infotype) {
        this.infotype = infotype == null ? null : infotype.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getOpername() {
        return opername;
    }

    public void setOpername(String opername) {
        this.opername = opername == null ? null : opername.trim();
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