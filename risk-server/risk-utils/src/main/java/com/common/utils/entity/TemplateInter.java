package com.common.utils.entity;

import com.common.utils.table.ColumnDesc;
import com.common.utils.table.IncrementAuto;
import com.common.utils.table.TimeStampAuto;

import java.util.Date;

/**
 * Created by zhenge.feng.
 */
public class TemplateInter {

    @IncrementAuto
    private Integer id;

    @ColumnDesc("模板ID")
    private Integer templateId;

    @ColumnDesc("产品ID")
    private Integer productId;

    @ColumnDesc("公司ID")
    private Integer companyId;

    @ColumnDesc("接口报告排序")
    private Integer orderIndex;

    @ColumnDesc("操作人名称")
    private String operName;

    @ColumnDesc("创建时间")
    private Date createTime;

    @ColumnDesc("更新时间")
    @TimeStampAuto
    private Date updateTime;

    public TemplateInter() {
    }

    public TemplateInter(Integer id, Integer productId, Integer companyId, Integer orderIndex, String operName) {
        this.id = id;
        this.productId = productId;
        this.companyId = companyId;
        this.orderIndex = orderIndex;
        this.operName = operName;
    }

    public TemplateInter(Integer id, Integer templateId, Integer productId, Integer companyId, Integer orderIndex, String operName, Date createTime) {
        this.id = id;
        this.templateId = templateId;
        this.productId = productId;
        this.companyId = companyId;
        this.orderIndex = orderIndex;
        this.operName = operName;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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
