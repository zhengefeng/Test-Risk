package com.common.utils.entity;

import com.common.utils.table.ColumnDesc;
import com.common.utils.table.IncrementAuto;
import com.common.utils.table.TimeStampAuto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品
 * Created by zhenge.feng.
 */
public class Product {

    @IncrementAuto
    private Integer id;

    @ColumnDesc("服务商ID")
    private Integer providerCode;

    @ColumnDesc("服务商接口ID")
    private Integer providerInterCode;

    @ColumnDesc("产品名称")
    private String name;

    @ColumnDesc("市场价")
    private BigDecimal marketPrice;

    @ColumnDesc("特价")
    private BigDecimal specialPrice;

    @ColumnDesc("成本价")
    private BigDecimal costPrice;

    @ColumnDesc("产品状态:1 正常 2停用")
    private Short status;

    @ColumnDesc("费用类型:1.查询 2.查得")
    private Short feeType;

    @ColumnDesc("产品信息类别")
    private String infoType;

    @ColumnDesc("产品描述")
    private String description;

    @ColumnDesc("操作人名称")
    private String operName;

    @ColumnDesc("创建时间")
    private Date  createTime;

    @TimeStampAuto
    @ColumnDesc("更新时间")
    private Date  updateTime;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(Integer providerCode) {
        this.providerCode = providerCode;
    }

    public Integer getProviderInterCode() {
        return providerInterCode;
    }

    public void setProviderInterCode(Integer providerInterCode) {
        this.providerInterCode = providerInterCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(BigDecimal specialPrice) {
        this.specialPrice = specialPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getFeeType() {
        return feeType;
    }

    public void setFeeType(Short feeType) {
        this.feeType = feeType;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
