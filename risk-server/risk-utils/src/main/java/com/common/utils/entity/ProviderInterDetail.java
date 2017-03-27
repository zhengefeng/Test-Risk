package com.common.utils.entity;

import com.common.utils.table.ColumnDesc;
import com.common.utils.table.IncrementAuto;
import com.common.utils.table.TimeStampAuto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 服务商接口明细
 * Created by zhenge.feng.
 */
public class ProviderInterDetail {

    @IncrementAuto
    private Integer id;

    @ColumnDesc("服务商ID")
    private Integer providerInterId;

    @ColumnDesc("服务商机构号")
    private Integer providerCode;

    @ColumnDesc("服务商接口rest code例5001")
    private Integer providerInterCode;

    @ColumnDesc("价格")
    private BigDecimal price;

    @ColumnDesc("服务商接口调用状态: 1成功 2失败")
    private Short status;

    @ColumnDesc("服务商接口调用参数")
    private String params;

    @ColumnDesc("服务商接口返回码")
    private String returnCode;

    @ColumnDesc("服务商接口返回结果  json格式")
    private String returnData;

    @ColumnDesc("创建时间")
    private Date createTime;

    @TimeStampAuto
    @ColumnDesc("更新时间")
    private Date updateTime;

    public ProviderInterDetail() {
    }

    public ProviderInterDetail(Integer id, Integer providerInterId, Integer providerCode, Integer providerInterCode, BigDecimal price, Short status, String params, String returnCode, String returnData) {
        this.id = id;
        this.providerInterId = providerInterId;
        this.providerCode = providerCode;
        this.providerInterCode = providerInterCode;
        this.price = price;
        this.status = status;
        this.params = params;
        this.returnCode = returnCode;
        this.returnData = returnData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProviderInterId() {
        return providerInterId;
    }

    public void setProviderInterId(Integer providerInterId) {
        this.providerInterId = providerInterId;
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
        this.params = params;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
