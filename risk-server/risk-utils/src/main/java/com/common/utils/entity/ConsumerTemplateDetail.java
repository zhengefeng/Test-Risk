package com.common.utils.entity;

import com.common.utils.table.ColumnDesc;
import com.common.utils.table.IncrementAuto;
import com.common.utils.table.TimeStampAuto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户调用模板流水
 * Created by zhenge.feng.
 */
public class ConsumerTemplateDetail {

    @IncrementAuto
    private Integer id;

    @ColumnDesc("客户ID")
    private Integer consumerId;

    @ColumnDesc("公司ID")
    private Integer companyId;

    @ColumnDesc("模板ID")
    private Integer templateId;

    @ColumnDesc("查询参数")
    private String params;

    @ColumnDesc("查询订单编号")
    private String orderId;

    @ColumnDesc("被查人姓名")
    private String personName;

    @ColumnDesc("被查人身份证号")
    private String cardId;

    @ColumnDesc("查询返回数据")
    private String returnData;

    @ColumnDesc("总价")
    private BigDecimal totalPrice;

    @ColumnDesc("创建时间")
    private Date createTime;

    @TimeStampAuto
    @ColumnDesc("更新时间")
    private Date updateTime;

    public ConsumerTemplateDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Integer consumerId) {
        this.consumerId = consumerId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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
