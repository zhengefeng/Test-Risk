package com.common.utils.entity;


import com.common.utils.table.ColumnDesc;
import com.common.utils.table.IncrementAuto;
import com.common.utils.table.TimeStampAuto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 服务商接口
 * Created by zhenge.feng.
 */
public class ProviderInter {

    @IncrementAuto
    private Integer id;

    @ColumnDesc("产品ID")
    private Integer productId;

    @ColumnDesc("服务商名称")
    private String name;

    @ColumnDesc("服务商机构号")
    private Integer providerCode;

    @ColumnDesc("服务商接口rest code")
    private Integer interCode;

    @ColumnDesc("服务商接口价格")
    private BigDecimal price;

    @ColumnDesc("价格类型:1查询 2查得 3查得按累别 4查得按篇 5查询按条")
    private Short feeType;

    @ColumnDesc("服务商接口状态:1 正常 2停用")
    private Short status;

    @ColumnDesc("更新时间")
    private Date updateTime;

    @TimeStampAuto
    private Date createTime;

    public ProviderInter() {
    }

    public ProviderInter(Integer id, Integer productId, String name, Integer providerCode, Integer interCode, BigDecimal price, Short feeType, Short status) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.providerCode = providerCode;
        this.interCode = interCode;
        this.price = price;
        this.feeType = feeType;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(Integer providerCode) {
        this.providerCode = providerCode;
    }

    public Integer getInterCode() {
        return interCode;
    }

    public void setInterCode(Integer interCode) {
        this.interCode = interCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getFeeType() {
        return feeType;
    }

    public void setFeeType(Short feeType) {
        this.feeType = feeType;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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
}
