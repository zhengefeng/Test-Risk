package com.common.utils.entity;

import com.common.utils.table.ColumnDesc;
import com.common.utils.table.IncrementAuto;
import com.common.utils.table.TimeStampAuto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 报告模板
 * Created by zhenge.feng.
 */
public class Template {

    @IncrementAuto
    private Integer id;

    @ColumnDesc("公司ID")
    private Integer companyId;

    @ColumnDesc("模板名称")
    private Integer tempName;

    @ColumnDesc("报告价格")
    private BigDecimal totalPrice;

    @ColumnDesc("模板状态:1正常 2停用")
    private Short status;

    @ColumnDesc("排序序号")
    private Integer orderIndex;

    @ColumnDesc("操作人名称")
    private String operName;

    @ColumnDesc("创建时间")
    private Date createTime;

    @TimeStampAuto
    @ColumnDesc("更新时间")
    private Date updateTime;

    public Template() {
    }

    public Template(Integer id, Integer companyId, Integer tempName, BigDecimal totalPrice, Short status, Integer orderIndex, String operName) {
        this.id = id;
        this.companyId = companyId;
        this.tempName = tempName;
        this.totalPrice = totalPrice;
        this.status = status;
        this.orderIndex = orderIndex;
        this.operName = operName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getTempName() {
        return tempName;
    }

    public void setTempName(Integer tempName) {
        this.tempName = tempName;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
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
